package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LightBlock extends Block{

	private int lightValue;
	
	/**
	 * 
	 * @param properties - the properties of the Block
	 * @param lightValue - has to be between 0 and 14
	 */
	public LightBlock(final Properties properties, final int lightValue) {
		super(properties);
		this.lightValue = lightValue;
	}
	
	@Override
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		if(adjacentBlockState.getBlock().equals(state.getBlock())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return lightValue;
	}
	@Override
	public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, PlacementType type,
			EntityType<?> entityType) {
		return false;
	}
	
}