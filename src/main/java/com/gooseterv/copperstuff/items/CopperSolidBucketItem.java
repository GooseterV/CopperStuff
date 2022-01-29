package com.gooseterv.copperstuff.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class CopperSolidBucketItem extends SolidBucketItem {

	
	public CopperSolidBucketItem(Block solidBlock, SoundEvent placeSound, Item.Properties properties) {
		super(solidBlock, placeSound, properties);
	}


	public InteractionResult useOn(UseOnContext p_151197_) {
		InteractionResult interactionresult = super.useOn(p_151197_);
		Player player = p_151197_.getPlayer();
		if (interactionresult.consumesAction() && player != null && !player.isCreative()) {
			InteractionHand interactionhand = p_151197_.getHand();
			player.setItemInHand(interactionhand, new ItemStack(RegisterItems.COPPER_BUCKET.get()));
		}
		return interactionresult;
	}
}
