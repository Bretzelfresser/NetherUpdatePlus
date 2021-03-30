package com.mrMint.netherUpdatePlus.common.items;

import java.util.List;
import java.util.function.Supplier;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BlazeBeatsMusicDisk extends MusicDiscItem{

	public BlazeBeatsMusicDisk(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder) {
		super(comparatorValue, soundSupplier, builder);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".blazeful_beats"));
	}
}
