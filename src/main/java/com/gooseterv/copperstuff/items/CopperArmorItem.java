package com.gooseterv.copperstuff.items;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;

public class CopperArmorItem extends ArmorItem {

	public CopperArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
		super(material, slot, properties);
	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		if ( stack.getItem() == RegisterItems.COPPER_HELMET.get() || stack.getItem() == RegisterItems.COPPER_CHESTPLATE.get() || stack.getItem() == RegisterItems.COPPER_BOOTS.get()) {
			return new ResourceLocation("copperstuff", "textures/models/armor/copper_1.png").toString();
		} else if( stack.getItem() == RegisterItems.COPPER_LEGGINGS.get()   ) {
			return new ResourceLocation("copperstuff", "textures/models/armor/copper_2.png").toString();
		}
		return super.getArmorTexture(stack, entity, slot, type);
	}
}
