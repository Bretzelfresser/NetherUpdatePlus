package com.mrMint.netherUpdatePlus.common.items;

import java.util.List;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class DevItem extends Item{

	public DevItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".dev_item"));
		tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".dev_item2"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
