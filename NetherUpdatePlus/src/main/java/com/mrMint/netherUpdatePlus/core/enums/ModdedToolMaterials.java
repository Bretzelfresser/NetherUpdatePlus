package com.mrMint.netherUpdatePlus.core.enums;

import com.mrMint.netherUpdatePlus.core.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ModdedToolMaterials implements IItemTier{
	orange_tungsten(5, 5, 816, 3, 4, ItemInit.ORANGE_TUNGSTEN_INGOT.get()),
	silver_tungsten(5, 5, 816, 3, 4, ItemInit.SILVER_TUNGSTEN_INGOT.get()),
	black_tungsten(5, 5, 816, 3, 4, ItemInit.BLACK_TUNGSTEN_INGOT.get());
	
	private float attackDamage, efficency;
	private int durability,harvestLevel ,enchantability;
	private Item repairMaterial;
	
	private ModdedToolMaterials(float attackDamage, float efficency, int durability, int harvestLevel,
			int enchantability, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficency = efficency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		return durability;
	}

	@Override
	public float getEfficiency() {
		return efficency;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}

}
