package com.gooseterv.copperstuff.items;



import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class AmethystArmor implements ArmorMaterial {
	public String getName() { return "amethyst"; }
	public int getEnchantmentValue() { return 20; } 
	public float getToughness() { return 2.5F; }
	public float getKnockbackResistance() { return 0.1F; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.AMETHYST_SHARD); }
	public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_DIAMOND; }
	public int getDurabilityForSlot(EquipmentSlot slot) {return  new int[]{14, 16, 16, 11}[slot.getIndex()]*37; }
	public int getDefenseForSlot(EquipmentSlot slot) {return new int[]{3, 5, 8, 3}[slot.getIndex()];}
}