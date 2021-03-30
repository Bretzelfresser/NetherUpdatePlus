package com.mrMint.netherUpdatePlus.core.enums;

import java.util.function.Supplier;

import com.mrMint.netherUpdatePlus.core.init.ItemInit;
import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.core.init.BlockInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModdedArmorMaterial implements IArmorMaterial{
	
	OrangeTungsten("orange_tungsten", 12, 9, new int[] {3,7,6,2}, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, 0, () -> {
		return Ingredient.fromItems(ItemInit.ORANGE_TUNGSTEN_INGOT.get());
	}),
	SilverTungsten("silver_tungsten", 12, 9, new int[] {3,7,6,2}, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, 0, () -> {
		return Ingredient.fromItems(ItemInit.SILVER_TUNGSTEN_INGOT.get());
	}),
	BlackTungsten("black_tungsten", 12, 9, new int[] {3,7,6,2}, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, 0, () -> {
		return Ingredient.fromItems(ItemInit.BLACK_TUNGSTEN_INGOT.get());
	}),
	Quartz("quartz", 12, 9, new int[] {3,7,6,2}, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, 0, () -> {
		return Ingredient.fromItems(BlockInit.QUARTZ_CRYSTAL_BLOCK.get().asItem());
	})
	;
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int maxDamageFactor, enchantability;
	private final int[] damgageReductionAmountArray;
	private final SoundEvent soundEvent;
	private final float toughness, knockbackResistance;
	private final Supplier<Ingredient> repairMaterial;

	private ModdedArmorMaterial(String name, int maxDamageFactor, int enchantability, int[] damgageReductionAmountArray,
			SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
		this.name = NetherUpdatePlus.MODID + ":" + name;
		this.maxDamageFactor = maxDamageFactor;
		this.enchantability = enchantability;
		this.damgageReductionAmountArray = damgageReductionAmountArray;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.damgageReductionAmountArray[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.get();
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

}
