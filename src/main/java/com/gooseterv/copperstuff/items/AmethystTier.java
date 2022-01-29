package com.gooseterv.copperstuff.items;


import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class AmethystTier implements Tier {
	public int   getUses()             { return 1952;}
	public float getSpeed()          { return 10.0F; }
	public float getAttackDamageBonus()        { return 5.0F; }
	public int   getLevel()        { return 2; }
	public int   getEnchantmentValue()      { return 12; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.AMETHYST_SHARD); }
}