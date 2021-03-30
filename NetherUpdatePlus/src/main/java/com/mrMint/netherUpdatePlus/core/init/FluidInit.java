package com.mrMint.netherUpdatePlus.core.init;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.fluids.SoulLava;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
	
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NetherUpdatePlus.MODID);
	
	public static final RegistryObject<FlowingFluid> SOUL_LAVA_SOURCE = FLUIDS.register("soul_lava_source", () -> new SoulLava.Source());
	public static final RegistryObject<FlowingFluid> SOUL_LAVA_FLOW = FLUIDS.register("soul_lava_flow", () -> new SoulLava.Flowing());

	
	
	public static final class Tags{
		
		public static final ITag.INamedTag<Fluid> SOUL_LAVA = modTags("soul_lava");
	}
	
	
	private static final ITag.INamedTag<Fluid> modTags(String path) {
		return FluidTags.makeWrapperTag(new ResourceLocation(NetherUpdatePlus.MODID, path).toString());
	}
}
