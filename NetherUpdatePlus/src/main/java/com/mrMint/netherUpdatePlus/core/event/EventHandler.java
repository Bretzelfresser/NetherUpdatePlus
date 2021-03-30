package com.mrMint.netherUpdatePlus.core.event;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.items.EnergyItem;
import com.mrMint.netherUpdatePlus.common.items.QuartzBoots;
import com.mrMint.netherUpdatePlus.core.init.ItemInit;
import com.mrMint.netherUpdatePlus.core.init.SoundInit;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = NetherUpdatePlus.MODID, bus = Bus.FORGE)
public class EventHandler {

	private static int ticks = 0;

	@SubscribeEvent
	public static void armorStandEvent(final EntityEvent event) {
		if (event.getEntity() instanceof ArmorStandEntity) {
			ArmorStandEntity armorStand = (ArmorStandEntity) event.getEntity();
			if (armorStand.getArmorInventoryList() != null) {
				for (ItemStack stack : armorStand.getArmorInventoryList()) {
					if (stack.getItem() instanceof QuartzBoots && armorStand.world
							.getBlockState(armorStand.getPosition().down()).getBlock().equals(Blocks.REDSTONE_BLOCK)) {
						armorStand.world.playSound(null, armorStand.getPosition(),
								SoundInit.QUARTZ_BOOTS_CHARGING_LAZY.get(), SoundCategory.NEUTRAL, 1000f, 0.1f);
						if (ticks >= 40) {
							QuartzBoots boots = (QuartzBoots) stack.getItem();
							boots.addEnergy(stack, 1);
							ticks = 0;
						}
					}
				}
				ticks++;
			}
		}
	}
	

	@SubscribeEvent
	public static void noFallDamage(final LivingDamageEvent event) {
		if (event.getSource().equals(DamageSource.FALL) && event.getEntityLiving() != null) {
			quartzBootsFallDamage(event);
		}
	}

	@SubscribeEvent
	public static void particles(final LivingJumpEvent event) {
		if (event.getEntityLiving().world.isRemote && event.getEntityLiving().getArmorInventoryList() != null) {
			for (ItemStack stack : event.getEntityLiving().getArmorInventoryList()) {
				if (stack.getItem() instanceof EnergyItem) {
					LivingEntity player = event.getEntityLiving();
					EnergyItem item = (EnergyItem) stack.getItem();
					;
					if (player instanceof PlayerEntity && !((PlayerEntity) player).isCreative()
							&& item.getEnergy(stack) >= 5)
						item.addEnergy(stack, -5);
				}
			}
		}
	}

	@SubscribeEvent
	public static void resetPlayerMovementSpeed(final LivingEquipmentChangeEvent event) {
		if (event.getFrom().getItem().equals(ItemInit.QUARTZ_BOOTS.get())) {
			event.getEntityLiving().getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.11f);
		}
	}
	
	@SubscribeEvent
	public static void onPlayerDeath(final LivingDeathEvent event) {
		if(event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			NonNullList<ItemStack> inventory = player.inventory.mainInventory;
			for(int i = 0;i< inventory.size();i++) {
				if(inventory.get(i).getItem().equals(ItemInit.ARCHIEVEMENT_ICON.get())) {
					inventory.set(i, ItemStack.EMPTY);
					player.sendMessage(new TranslationTextComponent("netherupdateplus.hoe_message"), player.getUniqueID());
				}
			}
		}
	}

	/**
	 * cuts the fall damage by half, and stops damaging at half a heart only works
	 * with quartzBoots and the energy of the quartBoots has to be greater then 25
	 * 
	 * @param event - the Damage event that is triggered
	 */
	private static void quartzBootsFallDamage(final LivingDamageEvent event) {
		if (event.getEntityLiving().getArmorInventoryList() != null) {
			for (ItemStack stack : event.getEntityLiving().getArmorInventoryList()) {
				if (stack.getItem().equals(ItemInit.QUARTZ_BOOTS.get())) {
					QuartzBoots boots = (QuartzBoots) stack.getItem();
					if (boots.getEnergy(stack) >= 25) {
						int newAmount = (int) (event.getAmount() / 2);
						if (event.getEntityLiving().getHealth() > newAmount) {
							event.setAmount(newAmount);
						} else {
							event.setAmount(event.getEntityLiving().getHealth() - 1.0f);
						}
						boots.addEnergy(stack, -25);
					}
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static void spawnParticles(LivingEntity entity, World world, int radius) {
		for (int i = 0; i <= 360; i++) {
			double angle = Math.toRadians(i);
			double x = entity.getPosX() + Math.sin(angle) * radius;
			double z = entity.getPosZ() + Math.cos(angle) * radius;
			if (world instanceof ServerWorld) {
				ServerWorld server = (ServerWorld) world;
				server.addParticle(new RedstoneParticleData(1, 1, 50, 1), x, entity.getPosY(), z, 0, 0.1, 0);
			}
		}
	}

}
