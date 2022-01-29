package com.gooseterv.copperstuff.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;

public class CopperBucketItem extends BucketItem {
	private final Fluid content;
	public CopperBucketItem(java.util.function.Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(supplier, builder);
		this.content = supplier.get();
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level p_40703_, Player p_40704_, InteractionHand p_40705_) {
			ItemStack itemstack = p_40704_.getItemInHand(p_40705_);
			BlockHitResult blockhitresult = getPlayerPOVHitResult(p_40703_, p_40704_, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
			InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(p_40704_, p_40703_, itemstack, blockhitresult);
			if (ret != null) return ret;
			if (blockhitresult.getType() == HitResult.Type.MISS) {
				return InteractionResultHolder.pass(itemstack);
			} else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
				return InteractionResultHolder.pass(itemstack);
			} else {
				System.out.println("DEBUG: Block is valid and is not of Type `Block`.");
				BlockPos blockpos = blockhitresult.getBlockPos();
				Direction direction = blockhitresult.getDirection();
				BlockPos blockpos1 = blockpos.relative(direction);
				if (p_40703_.mayInteract(p_40704_, blockpos) && p_40704_.mayUseItemAt(blockpos1, direction, itemstack)) {
					System.out.println("DEBUG: Block is interact-able and item can be used on.");
					if (this.content == Fluids.EMPTY || this.content == null) {
						System.out.println("DEBUG: Bucket has no fluids in it but `EMPTY`.");
						BlockState blockstate1 = p_40703_.getBlockState(blockpos);
						if (blockstate1.getBlock() instanceof BucketPickup) {
							System.out.println("DEBUG: Block is of instance BucketPickup");
							BucketPickup bucketpickup = (BucketPickup)blockstate1.getBlock();
							bucketpickup.pickupBlock(p_40703_, blockpos, blockstate1);
							ItemStack itemstack1 = checkBlockState(blockstate1);
							System.out.println("DEBUG: Itemstack - " + itemstack1.toString());
							if (!itemstack1.isEmpty()) {
								p_40704_.awardStat(Stats.ITEM_USED.get(this));
								bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
									p_40704_.playSound(p_150709_, 1.0F, 1.0F);
								});
								p_40703_.gameEvent(p_40704_, GameEvent.FLUID_PICKUP, blockpos);
								ItemStack itemstack2 = ItemUtils.createFilledResult(itemstack, p_40704_, itemstack1);
								if (!p_40703_.isClientSide) {
									CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)p_40704_, itemstack1);
								}
								System.out.println("DEBUG: Itemstack2 - " + itemstack2.toString());
								return InteractionResultHolder.sidedSuccess(itemstack2, p_40703_.isClientSide());
							}
						} else {
							System.out.println("DEBUG: Block is not of instance BucketPickup");
							System.out.println("DEBUG: Attempted block/state was: " + blockstate1.getBlock().toString());
							System.out.println("DEBUG: Attempted fluid/state was: " + blockstate1.getFluidState().toString());
						}
						return InteractionResultHolder.fail(itemstack);
					} else {
						System.out.println("DEBUG: Bucket has fluids in it other than `EMPTY`.");
						BlockState blockstate = p_40703_.getBlockState(blockpos);
						BlockPos blockpos2 = canBlockContainFluid(p_40703_, blockpos, blockstate) ? blockpos : blockpos1;
						if (this.emptyContents(p_40704_, p_40703_, blockpos2, blockhitresult)) {
							this.checkExtraContent(p_40704_, p_40703_, itemstack, blockpos2);
							if (p_40704_ instanceof ServerPlayer) {
								CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)p_40704_, blockpos2, itemstack);
							}

							p_40704_.awardStat(Stats.ITEM_USED.get(this));
							return InteractionResultHolder.sidedSuccess(getEmptySuccessItem(itemstack, p_40704_), p_40703_.isClientSide());
						} else {
							return InteractionResultHolder.fail(itemstack);
						}
					}
				} else {
					System.out.println("DEBUG: Block is not interact-able.");
					return InteractionResultHolder.fail(itemstack);
				}
			}
	}

	public static ItemStack getEmptySuccessItem(ItemStack p_40700_, Player p_40701_) {
		return !p_40701_.getAbilities().instabuild ? new ItemStack(RegisterItems.COPPER_BUCKET.get()) : p_40700_;
	}

	private boolean canBlockContainFluid(Level worldIn, BlockPos posIn, BlockState blockstate) {
		return blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer)blockstate.getBlock()).canPlaceLiquid(worldIn, posIn, blockstate, this.content);
	}
	private ItemStack checkBlockState(BlockState blockstate1) {
		
		if (blockstate1.getBlock() == Blocks.LAVA || blockstate1.getBlock() == Blocks.LAVA_CAULDRON) {
			
			return new ItemStack(RegisterItems.COPPER_LAVA_BUCKET.get());
		} else if (blockstate1.getBlock() == Blocks.WATER || blockstate1.getBlock() == Blocks.WATER_CAULDRON) {
			return new ItemStack(RegisterItems.COPPER_WATER_BUCKET.get());
		} else if (blockstate1.getBlock() == Blocks.POWDER_SNOW|| blockstate1.getBlock() == Blocks.POWDER_SNOW_CAULDRON) {
			return new ItemStack(RegisterItems.COPPER_SNOW_BUCKET.get());
		} else {
			return new ItemStack(RegisterItems.COPPER_BUCKET.get());
		}
	}

}
