package com.mrMint.netherUpdatePlus.common.blocks;

import net.minecraft.block.MagmaBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoulMagmaBlock extends MagmaBlock{

	public SoulMagmaBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		 if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
	         entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 2.0F);
	      }

	      super.onEntityWalk(worldIn, pos, entityIn);
	}

}
