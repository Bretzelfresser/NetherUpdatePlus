package com.mrMint.netherUpdatePlus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mrMint.netherUpdatePlus.core.init.BlockInit;
import com.mrMint.netherUpdatePlus.core.init.CommandSetup;
import com.mrMint.netherUpdatePlus.core.init.FluidInit;
import com.mrMint.netherUpdatePlus.core.init.ItemInit;
import com.mrMint.netherUpdatePlus.core.init.SoundInit;
import com.mrMint.netherUpdatePlus.world.OreGeneration;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("netherupdateplus")
public class NetherUpdatePlus {
	
	public static final String MODID = "netherupdateplus";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static final ItemGroup BUILDING_BLOCKS = new NetherUpdatePlusItemGroups("ores_blocks", BlockInit.GOLDENROD_NETHER_BRICKS);
	public static final ItemGroup COMBAT = new NetherUpdatePlusItemGroups("armor", ItemInit.ORANGE_TUNGSTEN_SWORD);
	public static final ItemGroup MISC = new NetherUpdatePlusItemGroups("misc", ItemInit.ORANGE_TUNGSTEN_INGOT);
	public static final ItemGroup TOOLS = new NetherUpdatePlusItemGroups("tools", ItemInit.BLACK_TUNGSTEN_AXE);
	public static final ItemGroup DECORATION_BLOCKS = new NetherUpdatePlusItemGroups("decoration_blocks", BlockInit.GOLDENROD_WEED);

	public NetherUpdatePlus() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		// Register the setup method for modloading
		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);
		
		SoundInit.SOUNDS.register(bus);
		
		FluidInit.FLUIDS.register(bus);
		
		BlockInit.DECORATION_BLOCKS.register(bus);
		BlockInit.BUILDING_BLOCKS.register(bus);
		BlockInit.BLOCKS.register(bus);
		BlockInit.TUNGSTEN_ORES.register(bus);
		BlockInit.SHADOW_ORES.register(bus);
		BlockInit.STAIRS.register(bus);
		BlockInit.SLABS.register(bus);
		BlockInit.WALLS.register(bus);
		BlockInit.FENCES.register(bus);
		
		ItemInit.ITEMS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
		
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		renderType();
	}

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(CommandSetup.class);
	}
	private void renderType() {
		RenderTypeLookup.setRenderLayer(BlockInit.TANZANITE_CRYSTAL_BLOCK.get(), net.minecraft.client.renderer.RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.QUARTZ_CRYSTAL_BLOCK.get(), net.minecraft.client.renderer.RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TANZANITE_QUARTZ_CRYSTAL_BLOCK.get(), net.minecraft.client.renderer.RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GOLDENROD_WEED.get(), net.minecraft.client.renderer.RenderType.getTranslucent());
	}
	
	private static class NetherUpdatePlusItemGroups extends ItemGroup {

		private RegistryObject<?> icon = null;
		
		public NetherUpdatePlusItemGroups(final String label, final RegistryObject<?> icon) {
			super(NetherUpdatePlus.MODID + "." + label);
			this.icon = icon;
		}
		

		@Override
		public ItemStack createIcon() {
			if(icon.get() instanceof Item) {
				Item i = (Item) icon.get();
				return i.getDefaultInstance();
			}else if(icon.get() instanceof Block) {
				Block b = (Block) icon.get();
				return b.asItem().getDefaultInstance();
			}
			return Items.BARRIER.asItem().getDefaultInstance();
		}

	}
}


