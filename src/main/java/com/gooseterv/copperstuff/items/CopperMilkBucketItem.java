package com.gooseterv.copperstuff.items;

//import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
public class CopperMilkBucketItem extends MilkBucketItem {

	public CopperMilkBucketItem(Item.Properties p_42921_) {
		super(p_42921_);
	}
 
	public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity p_42925_) {
		if (!p_42924_.isClientSide) p_42925_.curePotionEffects(p_42923_); // FORGE - move up so stack.shrink does not turn stack into air
		if (p_42925_ instanceof ServerPlayer) {
			ServerPlayer serverplayer = (ServerPlayer)p_42925_;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_42923_);
			serverplayer.awardStat(Stats.ITEM_USED.get(this));
		}
 
		if (p_42925_ instanceof Player && !((Player)p_42925_).getAbilities().instabuild) {
			p_42923_.shrink(1);
		}
 
		return p_42923_.isEmpty() ? new ItemStack(RegisterItems.COPPER_BUCKET.get()) : p_42923_;
	}
}
