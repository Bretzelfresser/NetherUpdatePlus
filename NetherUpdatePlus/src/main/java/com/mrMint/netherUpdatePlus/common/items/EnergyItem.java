package com.mrMint.netherUpdatePlus.common.items;

import java.util.List;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class EnergyItem extends ArmorItem{

	protected final int defaultMaxEnergy = 3600;
	
	public EnergyItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}
	
	public void setEnergy(ItemStack stack, int energy) {
		if (energy >= 0) {
			if (energy <= 3600) {
				stack.getTag().putInt("Energy", energy);
			} else {
				stack.getTag().putInt("Energy", getMaxEnergy(stack));
			}
		} else {
			stack.getTag().putInt("Energy", 0);
		}
	}
	
	public int getEnergy(ItemStack stack) {
		return !stack.hasTag() ? 0 : stack.getTag().getInt("Energy");
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".energy", getEnergy(stack), getMaxEnergy(stack)));
	}
	
	public void addEnergy(ItemStack stack, int energy) {
		if (getEnergy(stack) + energy <= getMaxEnergy(stack) && getEnergy(stack) + energy >= 0) {
			stack.getTag().putInt("Energy", getEnergy(stack) + energy);
		} else {
			stack.getTag().putInt("Energy", getMaxEnergy(stack));
		}
	}

	protected boolean hasMoved(PlayerEntity player, BlockPos prevPos) {
		if (comparePos(player.getPosition(), prevPos)) {
			return false;
		}
		return true;
	}
	
	protected boolean comparePos(BlockPos pos1, BlockPos pos2) {
		if (pos1.getX() == pos2.getX() && pos1.getY() == pos2.getY() && pos1.getZ() == pos2.getZ()) {
			return true;
		}
		return false;
	}
	
	public int getMaxEnergy(ItemStack stack) {
		return defaultMaxEnergy;
	}

}
