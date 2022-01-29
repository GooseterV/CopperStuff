package com.gooseterv.copperstuff.items;


import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CopperTier implements Tier {
	public int   getUses()             { return 192;}
	public float getSpeed()          { return 5.25F; }
	public float getAttackDamageBonus()        { return 1.85F; }
	public int   getLevel()        { return 2; }
	public int   getEnchantmentValue()      { return 12; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }
}