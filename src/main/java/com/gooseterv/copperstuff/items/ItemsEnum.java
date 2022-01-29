package com.gooseterv.copperstuff.items;


import net.minecraft.world.item.Item;

public enum ItemsEnum {
	AMETHYST_BLADE(RegisterItems.AMETHYST_BLADE.get()),
	AMETHYST_BOOTS(RegisterItems.AMETHYST_BOOTS.get()),
	AMETHYST_CHESTPLATE(RegisterItems.AMETHYST_CHESTPLATE.get()),
	AMETHYST_HELMET(RegisterItems.AMETHYST_HELMET.get()),
	AMETHYST_LEGGINGS(RegisterItems.AMETHYST_LEGGINGS.get()),
	AMETHYST_SWORD(RegisterItems.AMETHYST_SWORD.get()),
	AMETHYST_AXE(RegisterItems.AMETHYST_AXE.get()),
	AMETHYST_PICKAXE(RegisterItems.AMETHYST_PICKAXE.get()),
	AMETHYST_SHOVEL(RegisterItems.AMETHYST_SHOVEL.get()),
	AMETHYST_HOE(RegisterItems.AMETHYST_HOE.get()),
	COPPER_BUCKET(RegisterItems.COPPER_BUCKET.get()),
	COPPER_SNOW_BUCKET(RegisterItems.COPPER_SNOW_BUCKET.get()),
	COPPER_LAVA_BUCKET(RegisterItems.COPPER_LAVA_BUCKET.get()),
	COPPER_WATER_BUCKET(RegisterItems.COPPER_WATER_BUCKET.get()),
	COPPER_BOOTS(RegisterItems.COPPER_BOOTS.get()),
	COPPER_CHESTPLATE(RegisterItems.COPPER_CHESTPLATE.get()),
	COPPER_LEGGINGS(RegisterItems.COPPER_LEGGINGS.get()),
	COPPER_HELMET(RegisterItems.COPPER_HELMET.get()),
	COPPER_ROD(RegisterItems.COPPER_ROD.get()),
	COPPER_AXE(RegisterItems.COPPER_AXE.get()),
	COPPER_PICKAXE(RegisterItems.COPPER_PICKAXE.get()),
	COPPER_SWORD(RegisterItems.COPPER_SWORD.get()),
	COPPER_HOE(RegisterItems.COPPER_HOE.get()),
	COPPER_SHOVEL(RegisterItems.COPPER_SHOVEL.get());

	private final Item item;
	private ItemsEnum(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}
