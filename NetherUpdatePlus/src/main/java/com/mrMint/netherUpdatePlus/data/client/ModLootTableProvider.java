package com.mrMint.netherUpdatePlus.data.client;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrMint.netherUpdatePlus.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.fml.RegistryObject;

public class ModLootTableProvider extends ForgeLootTableProvider{

	public ModLootTableProvider(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
		
		return ImmutableList.of(
				Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
		map.forEach((p1, p2) -> LootTableManager.validateLootTable(validationtracker, p1, p2));
	}
	
	public static class ModBlockLootTables extends BlockLootTables{
		
		@Override
		protected void addTables() {
			registerDropSelfLootTable(BlockInit.GOLDENROD_NETHER_BRICKS.get());
			registerDropSelfLootTable(BlockInit.CHISLED_GOLDENROD_NETHER_BRICKS.get());
			registerDropSelfLootTable(BlockInit.CRACKED_GOLDENROD_NETHER_BRICKS.get());
		}
		
		@Override
		protected Iterable<Block> getKnownBlocks() {
			return BlockInit.BUILDING_BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
		}
		
		
	}

}
