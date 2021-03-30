package com.mrMint.netherUpdatePlus.core.init;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.blocks.BasicFence;
import com.mrMint.netherUpdatePlus.common.blocks.BasicSlab;
import com.mrMint.netherUpdatePlus.common.blocks.BasicStairBlock;
import com.mrMint.netherUpdatePlus.common.blocks.BasicWall;
import com.mrMint.netherUpdatePlus.common.blocks.GoldenrodWeedBlock;
import com.mrMint.netherUpdatePlus.common.blocks.LightBlock;
import com.mrMint.netherUpdatePlus.common.blocks.SoulMagmaBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = NetherUpdatePlus.MODID, bus = Bus.MOD)
public class BlockInit {

	private static AbstractBlock.Properties netherOres = Properties.create(Material.ROCK).hardnessAndResistance(15f, 5f)
			.sound(SoundType.NETHER_ORE).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool();
	private static AbstractBlock.Properties netherOresBlocks = Properties.create(Material.ROCK)
			.hardnessAndResistance(20f, 5f).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)
			.setRequiresTool();

	public static final DeferredRegister<Block> BUILDING_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> DECORATION_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> TUNGSTEN_ORES = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> STAIRS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> SLABS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> WALLS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> FENCES = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);
	public static final DeferredRegister<Block> SHADOW_ORES = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NetherUpdatePlus.MODID);

	public static final RegistryObject<Block> SOUL_MAGMA_BLOCK = BUILDING_BLOCKS.register("soul_magma_block", () -> new SoulMagmaBlock(Properties.from(Blocks.MAGMA_BLOCK)));
	public static final RegistryObject<Block> SOUL_LAVA_SOURCE = BLOCKS.register("soul_lava", () -> new FlowingFluidBlock(() -> FluidInit.SOUL_LAVA_SOURCE.get(), AbstractBlock.Properties.create(Material.LAVA).doesNotBlockMovement().noDrops().tickRandomly().hardnessAndResistance(100.0f).setLightLevel((state) -> 15)));
	
	public static final RegistryObject<Block> PUMMIS_BLOCK = BUILDING_BLOCKS.register("pummis_block", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PUMMIS_BRICKS = BUILDING_BLOCKS.register("pummis_bricks", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRACKEDPUMMIS_BRICKS = BUILDING_BLOCKS.register("cracked_pummis_bricks", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PUMMIS_TILES = BUILDING_BLOCKS.register("pummis_tiles", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_PUMMIS_BLOCK = BUILDING_BLOCKS.register("polished_pummis_block", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> BASALT_BRICKS = BUILDING_BLOCKS.register("basalt_bricks", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_BASALT = BUILDING_BLOCKS.register("burnished_basalt", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRACKED_BASALT_BRICKS = BUILDING_BLOCKS.register("cracked_basalt_bricks", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BASALT_PILLAR = BUILDING_BLOCKS.register("basalt_pillar", () -> new Block(Properties.from(Blocks.NETHER_BRICKS).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> CHISLED_GOLDENROD_NETHER_BRICKS = BUILDING_BLOCKS.register("chisled_goldenrod_nether_bricks", () -> new Block(AbstractBlock.Properties.from(Blocks.NETHER_BRICKS)));
	public static final RegistryObject<Block> CRACKED_GOLDENROD_NETHER_BRICKS = BUILDING_BLOCKS.register("cracked_goldenrod_nether_bricks", () -> new Block(AbstractBlock.Properties.from(Blocks.NETHER_BRICKS)));
	public static final RegistryObject<Block> GOLDENROD_NETHER_BRICKS = BUILDING_BLOCKS.register("goldenrod_nether_bricks", () -> new Block(AbstractBlock.Properties.from(Blocks.NETHER_BRICKS)));
	public static final RegistryObject<Block> GOLDENROD_NYLEUM_BLOCK = BLOCKS.register("goldenrod_nyleum_block", () -> new Block(AbstractBlock.Properties.from(Blocks.GRASS_BLOCK)));
	public static final RegistryObject<Block> GOLDENROD_WEED = BLOCKS.register("goldenrod_weed", () -> new GoldenrodWeedBlock(Properties.create(Material.PLANTS).zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT)));

	// Stairs
	public static final RegistryObject<Block> GOLDENROD_STAIR = STAIRS.register("goldenrod_stairs", () -> new BasicStairBlock(GOLDENROD_NETHER_BRICKS.get()));
	public static final RegistryObject<Block> BASALT_BRICKS_STAIRS = STAIRS.register("basalt_bricks_stairs", () -> new BasicStairBlock(BASALT_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_BASALT_STAIRS = STAIRS.register("polished_basalt_stairs", () -> new BasicStairBlock(POLISHED_BASALT.get()));
	public static final RegistryObject<Block> PUMMIS_TILES_STAIRS = STAIRS.register("pummis_tiles_stairs", () -> new BasicStairBlock(PUMMIS_TILES.get()));
	public static final RegistryObject<Block> PUMMIS_BRICKS_STAIRS = STAIRS.register("pummis_bricks_stairs", () -> new BasicStairBlock(PUMMIS_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_PUMMIS_STAIRS = STAIRS.register("polished_pummis_stairs", () -> new BasicStairBlock(POLISHED_PUMMIS_BLOCK.get()));

	// Slabs
	public static final RegistryObject<Block> GOLDENROD_SLAB = SLABS.register("goldenrod_slab", () -> new BasicSlab(GOLDENROD_NETHER_BRICKS.get()));
	public static final RegistryObject<Block> BASALT_BRICKS_SLAB = SLABS.register("basalt_bricks_slab", () -> new BasicSlab(BASALT_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_BASALT_SLAB = SLABS.register("polished_basalt_slab", () -> new BasicSlab(POLISHED_BASALT.get()));
	public static final RegistryObject<Block> PUMMIS_TILES_SLAB = SLABS.register("pummis_tiles_slab", () -> new BasicSlab(PUMMIS_TILES.get()));
	public static final RegistryObject<Block> PUMMIS_BRICKS_SLAB = SLABS.register("pummis_bricks_slab", () -> new BasicSlab(PUMMIS_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_PUMMIS_SLAB = SLABS.register("polished_pummis_slabs", () -> new BasicSlab(POLISHED_PUMMIS_BLOCK.get()));

	// Walls
	public static final RegistryObject<Block> GOLDENROD_WALL = WALLS.register("goldenrod_wall", () -> new BasicWall(GOLDENROD_NETHER_BRICKS.get()));
	public static final RegistryObject<Block> BASALT_WALL = WALLS.register("basalt_bricks_wall", () -> new BasicWall(BASALT_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_BASALT_WALL = WALLS.register("polished_basalt_wall", () -> new BasicWall(POLISHED_BASALT.get()));
	public static final RegistryObject<Block> PUMMIS_TILES_WALL = WALLS.register("pummis_tiles_wall", () -> new BasicWall(PUMMIS_TILES.get()));
	public static final RegistryObject<Block> PUMMIS_BRICKS_WALL = WALLS.register("pummis_bricks_wall", () -> new BasicWall(PUMMIS_BRICKS.get()));
	public static final RegistryObject<Block> POLISHED_PUMMIS_WALL = WALLS.register("polished_pummis_wall", () -> new BasicWall(POLISHED_PUMMIS_BLOCK.get()));

	// Fences
	public static final RegistryObject<Block> GOLDENROD_FENCE = FENCES.register("goldenrod_fence", () -> new BasicFence(GOLDENROD_NETHER_BRICKS.get(), AbstractBlock.Properties.from(Blocks.NETHER_BRICKS)));

	public static final RegistryObject<Block> TANZANITE_CRYSTAL_BLOCK = BUILDING_BLOCKS.register("tanzanite_crystal_block", () -> new LightBlock(Properties.create(Material.GLASS).notSolid().hardnessAndResistance(0.3f).sound(SoundType.GLASS), 5));
	public static final RegistryObject<Block> TANZANITE_QUARTZ_CRYSTAL_BLOCK = BUILDING_BLOCKS.register("tanzanite_quartz_crystal_block", () -> new LightBlock(Properties.create(Material.GLASS).notSolid().hardnessAndResistance(0.3f).sound(SoundType.GLASS), 5));
	public static final RegistryObject<Block> QUARTZ_CRYSTAL_BLOCK = BUILDING_BLOCKS.register("quartz_crystal_block",() -> new LightBlock(Properties.create(Material.GLASS).notSolid().hardnessAndResistance(0.3f).sound(SoundType.GLASS), 5));

	public static final RegistryObject<Block> SILVER_TUNGSTEN_ORE = TUNGSTEN_ORES.register("silver_tungsten",() -> new Block(netherOres));
	public static final RegistryObject<Block> ORANGE_TUNGSTEN_ORE = TUNGSTEN_ORES.register("orange_tungsten",() -> new Block(netherOres));
	public static final RegistryObject<Block> BLACK_TUNGSTEN_ORE = TUNGSTEN_ORES.register("black_tungsten",() -> new Block(netherOres));
	public static final RegistryObject<Block> PUMMIS_SILVER_TUNGSTEN_ORE = TUNGSTEN_ORES.register("pummis_silver_tungsten_ore",() -> new Block(netherOres));
	public static final RegistryObject<Block> PUMMIS_ORANGE_TUNGSTEN_ORE = TUNGSTEN_ORES.register("pummis_orange_tungsten_ore",() -> new Block(netherOres));
	public static final RegistryObject<Block> PUMMIS_BLACK_TUNGSTEN_ORE = TUNGSTEN_ORES.register("pummis_black_tungsten_ore",() -> new Block(netherOres));

	public static final RegistryObject<Block> BLACK_TUNGSTEN_BLOCK = TUNGSTEN_ORES.register("black_tungsten_block",() -> new Block(netherOresBlocks));
	public static final RegistryObject<Block> SILVER_TUNGSTEN_BLOCK = TUNGSTEN_ORES.register("silver_tungsten_block",() -> new Block(netherOresBlocks));
	public static final RegistryObject<Block> ORANGE_TUNGSTEN_BLOCK = TUNGSTEN_ORES.register("orange_tungsten_block",() -> new Block(netherOresBlocks));

	public static final RegistryObject<Block> SILVER_TUNGSTEN_SHADOW = SHADOW_ORES.register("silver_tungsten_shadow",() -> new Block(netherOres));
	public static final RegistryObject<Block> ORANGE_TUNGSTEN_SHADOW = SHADOW_ORES.register("orange_tungsten_shadow",() -> new Block(netherOres));
	public static final RegistryObject<Block> BLACK_TUNGSTEN_SHADOW = SHADOW_ORES.register("black_tungsten_shadow",() -> new Block(netherOres));

	public static final RegistryObject<Block> TANZANITE_ORE = BUILDING_BLOCKS.register("tanzanite_ore",() -> new Block(Properties.create(Material.ROCK).hardnessAndResistance(3f, 3f).sound(SoundType.NETHER_ORE).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	public static final RegistryObject<Block> TANZANITE_BLOCK = BUILDING_BLOCKS.register("tanzanite_block", () -> new Block(netherOresBlocks.hardnessAndResistance(3)));

	@SubscribeEvent
	public static void registerOreItems(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		BlockInit.BUILDING_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.BUILDING_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.TUNGSTEN_ORES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.BUILDING_BLOCKS)
					.isImmuneToFire();
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.STAIRS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.SLABS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.WALLS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.FENCES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		BlockInit.DECORATION_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		registry.register(new BlockItem(GOLDENROD_WEED.get(), new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS)).setRegistryName(GOLDENROD_WEED.get().getRegistryName()));
		registry.register(new BlockItem(GOLDENROD_NYLEUM_BLOCK.get(), new Item.Properties().group(NetherUpdatePlus.DECORATION_BLOCKS)).setRegistryName(GOLDENROD_NYLEUM_BLOCK.get().getRegistryName())); 
	}

	@SubscribeEvent
	public static void registerShadowOreItems(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		BlockInit.SHADOW_ORES.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties();
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}

}
