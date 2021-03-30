package com.mrMint.netherUpdatePlus.data;

import java.io.IOException;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.data.client.ItemModelsProvider;
import com.mrMint.netherUpdatePlus.data.client.ModBlockStatesprovider;
import com.mrMint.netherUpdatePlus.data.client.ModBlocktagsProvider;
import com.mrMint.netherUpdatePlus.data.client.ModFluidTagProvider;
import com.mrMint.netherUpdatePlus.data.client.RecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NetherUpdatePlus.MODID, bus = Bus.MOD)
public class DataGenerators {
	private DataGenerators() {
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		if (event.includeClient())
			gatherClientData(gen, helper);
		if (event.includeServer())
			gatherServerData(gen, helper);
		try {
			gen.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void gatherClientData(DataGenerator gen, ExistingFileHelper helper) {
		gen.addProvider(new ModBlockStatesprovider(gen, helper));
		gen.addProvider(new ItemModelsProvider(gen, helper));
	}

	private static void gatherServerData(DataGenerator gen, ExistingFileHelper helper) {
		gen.addProvider(new RecipeProvider(gen));
		gen.addProvider(new ModBlocktagsProvider(gen, helper));
		gen.addProvider(new ModFluidTagProvider(gen, helper));
		//gen.addProvider(new ModLootTableProvider(gen));
	}

}
