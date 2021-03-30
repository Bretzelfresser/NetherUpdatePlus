package com.mrMint.netherUpdatePlus.core.init;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			NetherUpdatePlus.MODID);

	public static final Lazy<SoundEvent> BLAZEFUL_BEATS_LAZY = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(NetherUpdatePlus.MODID, "item.blazeful_sound_disk")));
	public static final RegistryObject<SoundEvent> BLAZEFUL_BEATS = SOUNDS.register("item.blazeful_sound_disc",
			BLAZEFUL_BEATS_LAZY);

	public static final Lazy<SoundEvent> QUARTZ_BOOTS_TICKING_LAZY = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(NetherUpdatePlus.MODID, "item.quartz_boots_ticking")));
	public static final RegistryObject<SoundEvent> QUARTZ_BOOTS_TICKING = SOUNDS.register("item.quartz_boots_ticking",
			QUARTZ_BOOTS_TICKING_LAZY);

	public static final Lazy<SoundEvent> QUARTZ_BOOTS_CHARGING_STAR_LAZY = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(NetherUpdatePlus.MODID, "item.quartz_boots_charging_start")));
	public static final RegistryObject<SoundEvent> QUARTZ_BOOTS_CHARGING_START = SOUNDS
			.register("item.quartz_boots_charging_start", QUARTZ_BOOTS_CHARGING_STAR_LAZY);

	public static final Lazy<SoundEvent> QUARTZ_BOOTS_CHARGING_LAZY = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(NetherUpdatePlus.MODID, "item.quartz_boots_charging")));
	public static final RegistryObject<SoundEvent> QUARTZ_BOOTS_CHARGING = SOUNDS.register("item.quartz_boots_charging",
			QUARTZ_BOOTS_CHARGING_LAZY);
}
