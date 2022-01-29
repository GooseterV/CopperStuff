package com.gooseterv.copperstuff.items;



import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class CopperArmor implements ArmorMaterial {
	public String getName() { return "copper"; }
	public int getEnchantmentValue() { return 12; } 
	public float getToughness() { return 0.0F; }
	public float getKnockbackResistance() { return 0.0F; }
	public Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }
	public SoundEvent getEquipSound() { return SoundEvents.ARMOR_EQUIP_IRON; }
	public int getDurabilityForSlot(EquipmentSlot slot) {return  new int[]{13, 15, 16, 11}[slot.getIndex()]*15; }
	public int getDefenseForSlot(EquipmentSlot slot) {return new int[]{2, 4, 5, 2}[slot.getIndex()];}
}