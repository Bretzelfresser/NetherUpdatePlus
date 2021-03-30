package com.mrMint.netherUpdatePlus.common.fluids;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.core.init.BlockInit;
import com.mrMint.netherUpdatePlus.core.init.FluidInit;
import com.mrMint.netherUpdatePlus.core.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class SoulLava extends LavaFluid {

	@Override
	public Fluid getFlowingFluid() {
		return FluidInit.SOUL_LAVA_FLOW.get();
	}

	@Override
	public Fluid getStillFluid() {
		return FluidInit.SOUL_LAVA_SOURCE.get();
	}

	@Override
	public Item getFilledBucket() {
		return ItemInit.SOUL_LAVA_BUCKET.get();
	}

	@Override
	public BlockState getBlockState(FluidState state) {
		return BlockInit.SOUL_LAVA_SOURCE.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	protected void flowInto(IWorld worldIn, BlockPos pos, BlockState blockStateIn, Direction direction,
			FluidState fluidStateIn) {
		if (direction == Direction.DOWN) {
			FluidState fluidstate = worldIn.getFluidState(pos);
			if (this.isIn(FluidInit.Tags.SOUL_LAVA) && fluidstate.isTagged(FluidTags.WATER)) {
				if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
					worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory
							.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.STONE.getDefaultState()), 3);
				}

				this.triggerEffects(worldIn, pos);
				return;
			}
		}
	}
	
	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == FluidInit.SOUL_LAVA_FLOW.get() || fluidIn == FluidInit.SOUL_LAVA_SOURCE.get();
	}
	
	

	@Override
	protected FluidAttributes createAttributes() {
		System.out.println("hey");
		return FluidAttributes
				.builder(new ResourceLocation(NetherUpdatePlus.MODID, "fluids/soul_lava_still"),
						new ResourceLocation(NetherUpdatePlus.MODID, "fluids/soul_lava_flow"))
				.translationKey("block.netherupdateplus.soul_lava").luminosity(15).density(3000).viscosity(6000)
				.temperature(1300).sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA)
				.build(this);
	}

	private void triggerEffects(IWorld world, BlockPos pos) {
		world.playEvent(1501, pos, 0);
	}
	
	

	public static class Source extends SoulLava {
		public boolean isSource(FluidState state) {
			return true;
		}

		public int getLevel(FluidState state) {
			return 8;
		}

	}

	public static class Flowing extends SoulLava {

		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		public int getLevel(FluidState state) {
			return state.get(LEVEL_1_8);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

}
