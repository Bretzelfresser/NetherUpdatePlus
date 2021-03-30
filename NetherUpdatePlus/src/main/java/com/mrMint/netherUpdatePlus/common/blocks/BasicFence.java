package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;

public class BasicFence extends FenceBlock{

	private final Block block;
	
	public BasicFence(Block textureModel, Properties properties) {
		super(properties);
		this.block = textureModel;
	}
	public BasicFence(Block textureModel) {
		super(Properties.from(textureModel));
		this.block = textureModel;
	}
	
	public Block getTextureModel() {
		return this.block;
	}

}
