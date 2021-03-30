package com.mrMint.netherUpdatePlus.data.client;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.core.init.BlockInit;

import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocktagsProvider extends BlockTagsProvider{

	public ModBlocktagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, NetherUpdatePlus.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		addBeaconBlocks();
		addFences();
		addWalls();
		addNylium();
	}
	
	private void addNylium() {
		getOrCreateBuilder(Tags.Blocks.NYLUIM_BLOCK).add(BlockInit.GOLDENROD_NYLEUM_BLOCK.get())
				.add(Blocks.CRIMSON_NYLIUM)
				.add(Blocks.WARPED_NYLIUM);
	}
	
	private void addFences() {
		BlockInit.FENCES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(block);
		});
	}
	
	private void addWalls() {
		BlockInit.WALLS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			getOrCreateBuilder(BlockTags.WALLS).add(block);
		});
	}
	
	private void addBeaconBlocks() {
		getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS)
		.add(BlockInit.BLACK_TUNGSTEN_BLOCK.get())
		.add(BlockInit.SILVER_TUNGSTEN_BLOCK.get())
		.add(BlockInit.ORANGE_TUNGSTEN_BLOCK.get())
		.add(BlockInit.TANZANITE_BLOCK.get());
	}

}
