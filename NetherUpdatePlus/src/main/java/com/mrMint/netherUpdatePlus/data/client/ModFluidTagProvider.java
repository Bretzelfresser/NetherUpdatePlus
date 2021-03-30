package com.mrMint.netherUpdatePlus.data.client;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.core.init.FluidInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModFluidTagProvider extends FluidTagsProvider{

	public ModFluidTagProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, NetherUpdatePlus.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(FluidInit.Tags.SOUL_LAVA).add(FluidInit.SOUL_LAVA_FLOW.get()).add(FluidInit.SOUL_LAVA_SOURCE.get());
	}

}
