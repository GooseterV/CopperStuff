package com.gooseterv.copperstuff.items;


import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CopperWeaponTier implements Tier {
	public int   getUses()             { return 195;}
	public float getSpeed()          { return 5.25F; }
	public float getAttackDamageBonus()        { return 3.7F; }
	public int   getLevel()        { return 2; }
	public int   getEnchantmentValue()      { return 12; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }
}