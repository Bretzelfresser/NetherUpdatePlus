package com.mrMint.netherUpdatePlus.data.client;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.blocks.BasicFence;
import com.mrMint.netherUpdatePlus.common.blocks.BasicSlab;
import com.mrMint.netherUpdatePlus.common.blocks.BasicStairBlock;
import com.mrMint.netherUpdatePlus.common.blocks.BasicWall;
import com.mrMint.netherUpdatePlus.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockStatesprovider extends BlockStateProvider {

	private ExistingFileHelper helper;

	public ModBlockStatesprovider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, NetherUpdatePlus.MODID, exFileHelper);
		this.helper = exFileHelper;
	}

	@Override
	protected void registerStatesAndModels() {
		registerOres();
		registerShadowOres();
		registerStairs();
		registerSlabs();
		registerWalls();
		registerFences();
		registerBottomTopModel(BlockInit.GOLDENROD_NYLEUM_BLOCK.get(), modLoc("block/goldenrod_nyleum_block"), mcLoc("block/netherrack"), modLoc("block/goldenrod_nyleum_block_top"));
	}
	
	
	private void registerBottomTopModel(Block b, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		simpleBlock(b, new ModelFile.ExistingModelFile(modLoc("block/" + b.getRegistryName().getPath()), helper));
		models().cubeBottomTop(b.getRegistryName().getPath(), side, bottom, top);
		simpleBlockItem(b, new ModelFile.ExistingModelFile(modLoc("block/" + b.getRegistryName().getPath()), helper));
	}

	private void registerStairs() {
		BlockInit.STAIRS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block instanceof BasicStairBlock) {
				BasicStairBlock b = (BasicStairBlock) block;
				stairsBlock(b, modLoc("block/" + b.getTextureModel().getRegistryName().getPath()));
				simpleBlockItem(b,
						new ModelFile.ExistingModelFile(modLoc("block/" + b.getRegistryName().getPath()), helper));
			}
		});
	}

	private void registerSlabs() {
		BlockInit.SLABS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block instanceof BasicSlab) {
				BasicSlab b = (BasicSlab) block;
				ResourceLocation l = modLoc("block/" + b.getTextureModel().getRegistryName().getPath());
				slabBlock(b, l, l);
				simpleBlockItem(b,
						new ModelFile.ExistingModelFile(modLoc("block/" + b.getRegistryName().getPath()), helper));
			}
		});
	}

	private void registerWalls() {
		BlockInit.WALLS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block instanceof BasicWall) {
				BasicWall b = (BasicWall) block;
				wallBlock(b, modLoc("block/" + b.getTextureModel().getRegistryName().getPath()));
				models().wallInventory(b.getRegistryName().getPath() + "_inventory", modLoc("block/" + b.getTextureModel().getRegistryName().getPath()));
				itemModels().getBuilder(b.getRegistryName().getPath()).parent(itemModels().getExistingFile(modLoc("block/" + b.getRegistryName().getPath() + "_inventory")));
			}
		});
	}

	private void registerFences() {
		BlockInit.FENCES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block instanceof BasicFence) {
				BasicFence b = (BasicFence) block;
				fenceBlock(b, modLoc("block/" + b.getTextureModel().getRegistryName().getPath()));
				models().wallInventory(b.getRegistryName().getPath() + "_inventory", modLoc("block/" + b.getTextureModel().getRegistryName().getPath()));
				itemModels().getBuilder(b.getRegistryName().getPath()).parent(itemModels().getExistingFile(modLoc("block/" + b.getRegistryName().getPath() + "_inventory")));
			}
		});
	}

	private void registerOres() {
		BlockInit.BUILDING_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if(block.getRegistryName().getPath().equals("basalt_pillar")) {
				registerBottomTopModel(BlockInit.BASALT_PILLAR.get(), modLoc("block/basalt_pillar"), modLoc("block/basalt_pillar_top"), modLoc("block/basalt_pillar_top"));
			}else
				simpleBlock(block);
			simpleBlockItem(block,
					new ModelFile.ExistingModelFile(modLoc("block/" + block.getRegistryName().getPath()), helper));
		});
		BlockInit.TUNGSTEN_ORES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			simpleBlock(block);
			simpleBlockItem(block,
					new ModelFile.ExistingModelFile(modLoc("block/" + block.getRegistryName().getPath()), helper));
		});
		BlockInit.DECORATION_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			simpleBlock(block);
			simpleBlockItem(block,
					new ModelFile.ExistingModelFile(modLoc("block/" + block.getRegistryName().getPath()), helper));
		});
	}

	private void registerShadowOres() {
		BlockInit.SHADOW_ORES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			simpleBlock(block);
			simpleBlockItem(block,
					new ModelFile.ExistingModelFile(modLoc("block/" + block.getRegistryName().getPath()), helper));
		});
	}

}
