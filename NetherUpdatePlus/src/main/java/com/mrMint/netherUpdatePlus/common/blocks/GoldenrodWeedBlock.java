package com.mrMint.netherUpdatePlus.common.blocks;

import com.mrMint.netherUpdatePlus.core.init.BlockInit;
import com.mrMint.netherUpdatePlus.data.client.Tags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class GoldenrodWeedBlock extends Block{
	
	public GoldenrodWeedBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return validGround(state, worldIn, pos);
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return 3;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		return !validGround(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
	}
	
	protected boolean validGround(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState b = world.getBlockState(pos.down());
		return b.isIn(Tags.Blocks.NYLUIM_BLOCK);
	}
	
}
