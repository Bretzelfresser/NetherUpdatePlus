package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class BasicSlab extends SlabBlock{

	private final Block textureModel;
	
	public BasicSlab(Block model, Properties properties) {
		super(properties);
		this.textureModel = model;
	}
	public BasicSlab(Block model) {
		super(Properties.from(model));
		this.textureModel = model;
	}
	
	public Block getTextureModel() {
		return textureModel;
	}

}
