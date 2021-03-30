package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class BasicWall extends WallBlock{

	private final Block textureModel;
	
	public BasicWall(Block textureModel, Properties properties) {
		super(properties);
		this.textureModel = textureModel;
	}
	public BasicWall(Block textureModel) {
		super(Properties.from(textureModel));
		this.textureModel = textureModel;
	}

	public Block getTextureModel() {
		return textureModel;
	}

}
