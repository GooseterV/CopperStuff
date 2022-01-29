package com.gooseterv.copperstuff.items;


import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class AmethystWeaponTier implements Tier {
	public int   getUses()             { return 1952;}
	public float getSpeed()          { return 10.0F; }
	public float getAttackDamageBonus()        { return 9.0F; }
	public int   getLevel()        { return 4; }
	public int   getEnchantmentValue()      { return 19; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.AMETHYST_SHARD); }
}