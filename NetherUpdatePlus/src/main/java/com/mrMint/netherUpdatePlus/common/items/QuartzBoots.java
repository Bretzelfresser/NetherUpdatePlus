package com.mrMint.netherUpdatePlus.common.items;

import java.util.List;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.client.util.KeybordUtils;
import com.mrMint.netherUpdatePlus.core.init.SoundInit;

import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.RedstoneParticle;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class QuartzBoots extends EnergyItem {
	private int ticks;
	private SoundEvent charging, ticking;

	public QuartzBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn.rarity(Rarity.RARE));
		ticks = 0;
		charging = SoundInit.QUARTZ_BOOTS_CHARGING_LAZY.get();
		ticking = SoundInit.QUARTZ_BOOTS_TICKING_LAZY.get();
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		if (world.isRemote) {
			if (isCharging(stack) && !player.isCreative()) {
				world.playSound(player, player.getPosition(), charging, SoundCategory.NEUTRAL, 400, 0.1f);
			}
		}else {
			if (getEnergy(stack) <= 60 && getEnergy(stack) >= 1 && !isCharging(stack) && !player.isCreative()) {
				if (getTickingSoundTicks(stack) <= 0) {
					world.playSound(null, player.getPosition(), ticking, SoundCategory.NEUTRAL, 0.15f, 0.1f);
					setTickingSoundTicks(stack, 25);
				} else {
					addTickingSoundTicks(stack, -1);
				}
			}else {
				setTickingSoundTicks(stack, 0);
			}
		}
		if (world.isRemote && ((player.getMotion().getY() > 0 || hasMoved(player, getPrevBlockPos(stack)))
				&& (getEnergy(stack) >= 5) || player.isCreative())) {
			spawnParticles(player, world);
			if (player.isCreative()) {
				setPrevBlockPos(stack, player.getPosition());
			}
		}
		if (!player.world.isRemote()) {
			if (!player.isCreative()) {
				if (getEnergy(stack) >= 1) {
					if (getEnergy(stack) >= 5)
						player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 2, 4, false, false, false));
					player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
					if (ticks >= 20 && hasMoved(player, getPrevBlockPos(stack))) {
						ticks = 0;
						setPrevBlockPos(stack, player.getPosition());
						addEnergy(stack, -1);
					}
					// reset player speed
				} else {
					player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1f);
				}
				// charge on Redstone block
				if (player.world.getBlockState(player.getPosition().down()).getBlock().equals(Blocks.REDSTONE_BLOCK)
						&& getEnergy(stack) <= getMaxEnergy(stack)) {
					if (ticks >= 40) {
						ticks = 0;
						addEnergy(stack, 1);
					}
					setCharging(stack, true);
				} else {
					setFirstCharging(stack, true);
					setCharging(stack, false);
				}
				// losing power in water
				if (player.isInWater() && ticks >= 20) {
					addEnergy(stack, -3);
					ticks = 0;
				}
				ticks++;
			} else {
				player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 3, 4, false, false, false));
				player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double) 0.225F);
			}
		}
	}

	private void spawnParticles(PlayerEntity player, World world) {
		Vector3i direction = player.getHorizontalFacing().getDirectionVec();
		Vector3d look = new Vector3d(direction.getX(), direction.getY(), direction.getZ()).normalize();
		Vector3d leg1 = look.rotateYaw((float) (Math.PI / 2)).mul(0.25, 0.25, 0.25);
		Vector3d leg2 = leg1.mul(-1, -1, -1);
		world.addParticle(new RedstoneParticleData(1, 0, 0, 1), player.getPosX() + leg1.getX(),
				player.getPosY() + leg1.getY(), player.getPosZ() + leg1.getZ(), 0, -0.1, 0);
		world.addParticle(new RedstoneParticleData(1, 0, 0, 1), player.getPosX() + leg2.getX(),
				player.getPosY() + leg2.getY(), player.getPosZ() + leg2.getZ(), 0, -0.1, 0);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".quartz_boots"));
		if (!KeybordUtils.isHoldingShift())
			tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".quartz_boots1",
					TextFormatting.AQUA, TextFormatting.RESET));
		else {
			tooltip.add(new TranslationTextComponent("tooltip." + NetherUpdatePlus.MODID + ".quartz_boots2"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	public boolean isFirstCharging(ItemStack stack) {
		return !stack.hasTag() ? false : stack.getTag().getBoolean("firstCharging1");
	}

	public boolean isCharging(ItemStack stack) {
		return !stack.hasTag() ? false : stack.getTag().getBoolean("charging");
	}

	protected void setTickingSoundTicks(ItemStack stack, int ticks) {
		stack.getTag().putInt("ticking", ticks);
	}

	protected void addTickingSoundTicks(ItemStack stack, int addition) {
		stack.getTag().putInt("ticking", getTickingSoundTicks(stack) + addition);
	}

	protected int getTickingSoundTicks(ItemStack stack) {
		return !stack.hasTag() ? 0 : stack.getTag().getInt("ticking");
	}

	public void setFirstCharging(ItemStack stack, boolean charging) {
		stack.getTag().putBoolean("firstCharging1", charging);
	}

	public void setCharging(ItemStack stack, boolean charging) {
		stack.getOrCreateTag().putBoolean("charging", charging);
	}

	protected void setPrevBlockPos(ItemStack stack, BlockPos pos) {
		stack.getOrCreateTag().putInt("prevPosX", pos.getX());
		stack.getOrCreateTag().putInt("prevPosY", pos.getY());
		stack.getOrCreateTag().putInt("prevPosZ", pos.getZ());
	}

	protected BlockPos getPrevBlockPos(ItemStack stack) {
		if (stack.hasTag()) {
			int x = stack.getTag().getInt("prevPosX");
			int y = stack.getTag().getInt("prevPosY");
			int z = stack.getTag().getInt("prevPosZ");
			return new BlockPos(x, y, z);
		}
		return new BlockPos(0, 0, 0);
	}

}
