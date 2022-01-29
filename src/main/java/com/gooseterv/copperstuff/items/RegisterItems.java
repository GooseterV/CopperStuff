package com.gooseterv.copperstuff.items;

import com.gooseterv.copperstuff.CopperStuff;

import com.google.common.base.Supplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
//import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ShovelItem;
//import net.minecraftforge.client.FluidContainerColorer;
//import net.minecraftforge.fluids.FluidAttributes.Water;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.Fluids;
//import net.minecraftforge.fluids.capability.ItemFluidContainer;

//import net.minecraft.world.item.ArmorItem;
//import net.minecraft.world.level.material.WaterFluid;
//import net.minecraft.world.item.SolidBucketItem;
//import net.minecraft.world.item.MilkBucketItem;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;


public class RegisterItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CopperStuff.MOD_ID);
	public static final CopperTier CopperTier = new CopperTier();
	public static final CopperWeaponTier CopperWeaponTier = new CopperWeaponTier();
	public static final AmethystWeaponTier AmethystWeaponTier= new AmethystWeaponTier();
	public static final CopperArmor COPPER_ARMOR = new CopperArmor();
	public static final AmethystArmor AMETHYST_ARMOR = new AmethystArmor();
	public static final AmethystTier AmethystTier = new AmethystTier();

	public static final RegistryObject<Item> COPPER_PICKAXE = register("copper_pickaxe", 
			() -> (
				new PickaxeItem(CopperTier, 0, 0, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_AXE = register("copper_axe", 
			() -> (
				new AxeItem(CopperWeaponTier, 0, 0, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_SWORD = register("copper_sword", 
			() -> (
				new SwordItem(CopperWeaponTier, 0, 0, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_SHOVEL = register("copper_shovel", 
			() -> (
				new ShovelItem(CopperTier, 0, 0, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_HOE = register("copper_hoe", 
			() -> (
				new HoeItem(CopperTier, 0, 0, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);
	
	public static final RegistryObject<Item> COPPER_CHESTPLATE = register("copper_chestplate", 
		() -> (
			new CopperArmorItem(COPPER_ARMOR, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> COPPER_LEGGINGS = register("copper_leggings", 
		() -> (
			new CopperArmorItem(COPPER_ARMOR, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> COPPER_BOOTS = register("copper_boots", 
		() -> (
			new CopperArmorItem(COPPER_ARMOR, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> COPPER_HELMET = register("copper_helmet", 
		() -> (
			new CopperArmorItem(COPPER_ARMOR, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).durability(192).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> AMETHYST_HELMET = register("amethyst_helmet", 
		() -> (
			new AmethystArmorItem(AMETHYST_ARMOR, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> AMETHYST_CHESTPLATE = register("amethyst_chestplate", 
		() -> (
			new AmethystArmorItem(AMETHYST_ARMOR, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> AMETHYST_LEGGINGS= register("amethyst_leggings", 
		() -> (
			new AmethystArmorItem(AMETHYST_ARMOR, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> AMETHYST_BOOTS = register("amethyst_boots", 
		() -> (
			new AmethystArmorItem(AMETHYST_ARMOR, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
		)
	);

	public static final RegistryObject<Item> AMETHYST_BLADE = register("amethyst_blade", 
		() -> (
			new Item(new Item.Properties().stacksTo(32).tab(CopperStuff.CREATIVE_TAB))
		)
	);

	public static final RegistryObject<Item> COPPER_ROD = register("copper_rod", 
		() -> (
			new Item(new Item.Properties().stacksTo(64).tab(CopperStuff.CREATIVE_TAB))
		)
	);

	public static final RegistryObject<Item> AMETHYST_SWORD = register("amethyst_sword", 
			() -> (
				new SwordItem(AmethystWeaponTier, 0, 0, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> AMETHYST_PICKAXE = register("amethyst_pickaxe", 
			() -> (
				new PickaxeItem(AmethystTier, 0, 0, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> AMETHYST_AXE = register("amethyst_axe", 
			() -> (
				new AxeItem(AmethystWeaponTier, 0, 0, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> AMETHYST_SHOVEL = register("amethyst_shovel", 
			() -> (
				new ShovelItem(AmethystTier, 0, 0, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> AMETHYST_HOE = register("amethyst_hoe", 
			() -> (
				new HoeItem(AmethystTier, 0, 0, new Item.Properties().stacksTo(1).durability(1952).tab(CopperStuff.CREATIVE_TAB)).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_BUCKET = register("copper_bucket", 
			() -> (
				new CopperBucketItem( ()->Fluids.EMPTY , new Item.Properties().stacksTo(16).tab(CopperStuff.CREATIVE_TAB) ).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_WATER_BUCKET = register("copper_water_bucket", 
			() -> (
				new CopperBucketItem( ()->Fluids.WATER, new Item.Properties().stacksTo(1).tab(CopperStuff.CREATIVE_TAB) ).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_LAVA_BUCKET = register("copper_lava_bucket", 
			() -> (
				new CopperBucketItem(()->Fluids.LAVA, new Item.Properties().stacksTo(1).tab(CopperStuff.CREATIVE_TAB) ).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_SNOW_BUCKET = register("copper_snow_bucket", 
			() -> (
				new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.POWDER_SNOW_PLACE, new Item.Properties().stacksTo(1).tab(CopperStuff.CREATIVE_TAB) ).asItem()
			)
	);

	public static final RegistryObject<Item> COPPER_MILK_BUCKET = register("copper_milk_bucket", 
			() -> (
				new CopperMilkBucketItem(new Item.Properties().stacksTo(1).tab(CopperStuff.CREATIVE_TAB) ).asItem()
			)
	);

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}


	
	
}