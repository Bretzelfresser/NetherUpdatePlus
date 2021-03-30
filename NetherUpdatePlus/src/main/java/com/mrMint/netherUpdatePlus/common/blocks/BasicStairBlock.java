package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class BasicStairBlock extends StairsBlock{

	private final Block textureModel;
	
	public BasicStairBlock(Block block, Properties properties) {
		super(() -> block.getDefaultState(), properties);
		this.textureModel = block;
	}
	public BasicStairBlock(Block block) {
		super(() -> block.getDefaultState(), AbstractBlock.Properties.from(block));
		this.textureModel = block;
	}
	
	public Block getTextureModel() {
		return textureModel;
	}

}
