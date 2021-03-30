package com.mrMint.netherUpdatePlus.data.client;

import java.util.function.Consumer;

import com.mrMint.netherUpdatePlus.core.init.BlockInit;
import com.mrMint.netherUpdatePlus.core.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class RecipeProvider extends net.minecraft.data.RecipeProvider implements IConditionBuilder {

	public RecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		createToolRecipes(consumer, ItemInit.SILVER_TUNGSTEN_INGOT.get(), "tungsten");
		createToolRecipes(consumer, ItemInit.BLACK_TUNGSTEN_INGOT.get(), "tungsten");
		createToolRecipes(consumer, ItemInit.ORANGE_TUNGSTEN_INGOT.get(), "tungsten");
		createArmorRecipes(consumer, ItemInit.SILVER_TUNGSTEN_INGOT.get(), "tungsten");
		createArmorRecipes(consumer, ItemInit.BLACK_TUNGSTEN_INGOT.get(), "tungsten");
		createArmorRecipes(consumer, ItemInit.ORANGE_TUNGSTEN_INGOT.get(), "tungsten");

		create9Recipe(consumer, ItemInit.SILVER_TUNGSTEN_INGOT.get(), BlockInit.SILVER_TUNGSTEN_BLOCK.get().asItem());
		create9Recipe(consumer, ItemInit.BLACK_TUNGSTEN_INGOT.get(), BlockInit.BLACK_TUNGSTEN_BLOCK.get().asItem());
		create9Recipe(consumer, ItemInit.ORANGE_TUNGSTEN_INGOT.get(), BlockInit.ORANGE_TUNGSTEN_BLOCK.get().asItem());
		create9Recipe(consumer, ItemInit.SILVER_TUNGSTEN_NUGGET.get(), ItemInit.SILVER_TUNGSTEN_INGOT.get(), "2");
		create9Recipe(consumer, ItemInit.BLACK_TUNGSTEN_NUGGET.get(), ItemInit.BLACK_TUNGSTEN_INGOT.get(), "2");
		create9Recipe(consumer, ItemInit.ORANGE_TUNGSTEN_NUGGET.get(), ItemInit.ORANGE_TUNGSTEN_INGOT.get(), "2");

		create4Recipe(consumer, ItemInit.SILVER_TUNGSTEN_SCRAP.get(), ItemInit.SILVER_TUNGSTEN_INGOT.get());
		create4Recipe(consumer, ItemInit.BLACK_TUNGSTEN_SCRAP.get(), ItemInit.BLACK_TUNGSTEN_INGOT.get());
		create4Recipe(consumer, ItemInit.ORANGE_TUNGSTEN_SCRAP.get(), ItemInit.ORANGE_TUNGSTEN_INGOT.get());
		create4Recipe(consumer, Blocks.BASALT.asItem(), BlockInit.POLISHED_BASALT.get().asItem(), 4);
		create4Recipe(consumer, BlockInit.POLISHED_BASALT.get().asItem(), BlockInit.BASALT_BRICKS.get().asItem(), 4);

		createCrystals(consumer);
		createQuartzBoots(consumer);
		createTanzaniteQuartz(consumer);
		createGoldenrodStuff(consumer);
		createBasaltStuff(consumer);
		createPummisStuff(consumer);
		createShapelessRecipe(consumer);

		createSmeltingRecipes(consumer);
	}

	private void createSmeltingRecipes(Consumer<IFinishedRecipe> consumer) {
		createBasicSmelting(consumer, BlockInit.GOLDENROD_NETHER_BRICKS.get(), BlockInit.CRACKED_GOLDENROD_NETHER_BRICKS.get(), 200);
		createBasicSmelting(consumer, BlockInit.BASALT_BRICKS.get(), BlockInit.CRACKED_BASALT_BRICKS.get(), 200);
	}
	
	private void createShapelessRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(BlockInit.BASALT_PILLAR.get(), 2).addIngredient(BlockInit.POLISHED_BASALT.get(), 2).addCriterion("hasName", hasItem(BlockInit.BASALT_PILLAR.get().asItem())).build(consumer);
	}
	
	private void createPummisStuff(Consumer<IFinishedRecipe> consumer) {
		createStairsRecipe(consumer, BlockInit.PUMMIS_BRICKS.get(), BlockInit.PUMMIS_BRICKS_STAIRS.get(), 4);
		createSlabRecipe(consumer, BlockInit.PUMMIS_BRICKS.get(), BlockInit.PUMMIS_BRICKS_SLAB.get(), 6);
		createWallRecipe(consumer, BlockInit.PUMMIS_BRICKS.get(), BlockInit.PUMMIS_BRICKS_WALL.get(), 6);
		createStairsRecipe(consumer, BlockInit.POLISHED_PUMMIS_BLOCK.get(), BlockInit.POLISHED_PUMMIS_STAIRS.get(), 4);
		createSlabRecipe(consumer, BlockInit.POLISHED_PUMMIS_BLOCK.get(), BlockInit.POLISHED_PUMMIS_SLAB.get(), 6);
		createWallRecipe(consumer, BlockInit.POLISHED_PUMMIS_BLOCK.get(), BlockInit.POLISHED_PUMMIS_WALL.get(), 6);
	}
	
	private void createBasaltStuff(Consumer<IFinishedRecipe> consumer) {
		createStairsRecipe(consumer, BlockInit.BASALT_BRICKS.get(), BlockInit.BASALT_BRICKS_STAIRS.get(), 4);
		createSlabRecipe(consumer, BlockInit.BASALT_BRICKS.get(), BlockInit.BASALT_BRICKS_SLAB.get(), 6);
		createWallRecipe(consumer, BlockInit.BASALT_BRICKS.get(), BlockInit.BASALT_WALL.get(), 6);
		createStairsRecipe(consumer, BlockInit.POLISHED_BASALT.get(), BlockInit.POLISHED_BASALT_STAIRS.get(), 4);
		createWallRecipe(consumer, BlockInit.POLISHED_BASALT.get(), BlockInit.POLISHED_BASALT_WALL.get(), 6);
		createSlabRecipe(consumer, BlockInit.POLISHED_BASALT.get(), BlockInit.POLISHED_BASALT_SLAB.get(), 6);
	}
	

	private void createBasicSmelting(Consumer<IFinishedRecipe> consumer, Block block, Block result, int smeltingTime) {
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(block.asItem()),
				result.asItem(), 0.7f, 200).addCriterion("hasItem", hasItem(block.asItem())).build(consumer);
	}

	private void createTanzaniteQuartz(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(ItemInit.TANZANITE_QUARTZ.get(), 4)
				.key('q', Ingredient.fromItems(Items.QUARTZ))
				.key('t', Ingredient.fromItems(ItemInit.TANZANITE_ITEM.get())).patternLine("t  ").patternLine("q  ")
				.addCriterion("hasItem", hasItem(ItemInit.TANZANITE_ITEM.get())).build(consumer);

	}
	
	private void createStairsRecipe(Consumer<IFinishedRecipe> consumer, Block block,Block stairs, int count) {
		ShapedRecipeBuilder.shapedRecipe(stairs, count)
		.key('#', Ingredient.fromItems(block.asItem())).patternLine("#  ")
		.patternLine("## ").patternLine("###")
		.addCriterion("hasItem", hasItem(block.asItem())).build(consumer);
	}
	
	private void createWallRecipe(Consumer<IFinishedRecipe> consumer, Block block,Block wall, int count) {
		ShapedRecipeBuilder.shapedRecipe(wall.asItem(), count)
		.key('#', Ingredient.fromItems(block.asItem())).patternLine("###")
		.patternLine("###").patternLine("   ")
		.addCriterion("hasItem", hasItem(block.asItem())).build(consumer);
	}
	private void createSlabRecipe(Consumer<IFinishedRecipe> consumer, Block block,Block slab, int count) {
		ShapedRecipeBuilder.shapedRecipe(slab, count)
		.key('#', Ingredient.fromItems(block.asItem())).patternLine("###")
		.patternLine("   ").patternLine("   ")
		.addCriterion("hasItem", hasItem(block.asItem())).build(consumer);
	}

	private void createGoldenrodStuff(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem(), 4)
				.key('#', Ingredient.fromItems(Items.NETHER_BRICK)).key('y', Ingredient.fromItems(Items.YELLOW_DYE))
				.patternLine("#y ").patternLine("y# ").patternLine("   ")
				.addCriterion("hasItem", hasItem(Items.NETHER_BRICK)).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.CHISLED_GOLDENROD_NETHER_BRICKS.get().asItem())
				.key('#', Ingredient.fromItems(BlockInit.GOLDENROD_SLAB.get().asItem())).patternLine("#  ")
				.patternLine("#  ").patternLine("   ")
				.addCriterion("hasItem", hasItem(BlockInit.GOLDENROD_SLAB.get().asItem())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.GOLDENROD_WALL.get().asItem(), 6)
				.key('#', Ingredient.fromItems(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).patternLine("###")
				.patternLine("###").patternLine("   ")
				.addCriterion("hasItem", hasItem(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.GOLDENROD_STAIR.get().asItem(), 4)
				.key('#', Ingredient.fromItems(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).patternLine("#  ")
				.patternLine("## ").patternLine("###")
				.addCriterion("hasItem", hasItem(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.GOLDENROD_FENCE.get().asItem(), 6)
				.key('#', Ingredient.fromItems(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem()))
				.key('s', Ingredient.fromItems(BlockInit.GOLDENROD_SLAB.get().asItem())).patternLine("#s#")
				.patternLine("#s#").patternLine("   ")
				.addCriterion("hasItem", hasItem(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.GOLDENROD_SLAB.get().asItem(), 6)
				.key('#', Ingredient.fromItems(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).patternLine("###")
				.patternLine("   ").patternLine("   ")
				.addCriterion("hasItem", hasItem(BlockInit.GOLDENROD_NETHER_BRICKS.get().asItem())).build(consumer);
	}

	private void createCrystals(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BlockInit.QUARTZ_CRYSTAL_BLOCK.get().asItem())
				.key('#', Ingredient.fromItems(Items.QUARTZ)).key('g', Ingredient.fromItems(Blocks.GLASS.asItem()))
				.patternLine("#g#").patternLine("g#g").patternLine("#g#").addCriterion("hasItem", hasItem(Items.QUARTZ))
				.build(consumer);
		ShapedRecipeBuilder.shapedRecipe(BlockInit.TANZANITE_QUARTZ_CRYSTAL_BLOCK.get().asItem())
				.key('#', Ingredient.fromItems(ItemInit.TANZANITE_QUARTZ.get()))
				.key('g', Ingredient.fromItems(Blocks.GLASS.asItem())).patternLine("#g#").patternLine("g#g")
				.patternLine("#g#").addCriterion("hasItem", hasItem(ItemInit.TANZANITE_QUARTZ.get())).build(consumer);
		ShapedRecipeBuilder.shapedRecipe(BlockInit.TANZANITE_CRYSTAL_BLOCK.get().asItem())
				.key('#', Ingredient.fromItems(ItemInit.TANZANITE_ITEM.get()))
				.key('g', Ingredient.fromItems(Blocks.GLASS.asItem())).patternLine("#g#").patternLine("g#g")
				.patternLine("#g#").addCriterion("hasItem", hasItem(ItemInit.TANZANITE_ITEM.get())).build(consumer);
	}

	private void createQuartzBoots(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(ItemInit.QUARTZ_BOOTS.get()).key('d', Ingredient.fromItems(Items.DIAMOND))
				.key('r', Ingredient.fromItems(Items.REDSTONE)).key('n', Ingredient.fromItems(Items.NETHERITE_SCRAP))
				.key('q', Ingredient.fromItems(ItemInit.TANZANITE_QUARTZ.get())).patternLine("qdq").patternLine("qrq")
				.patternLine("ndn").addCriterion("hasItem", hasItem(ItemInit.TANZANITE_QUARTZ.get())).build(consumer);
	}

	private void createArmorRecipes(Consumer<IFinishedRecipe> consumer, Item material, String discription) {
		createHelmet(consumer, material, findToolOrArmor(material, discription + "_helmet"));
		createChestplate(consumer, material, findToolOrArmor(material, discription + "_chestplate"));
		createLeggings(consumer, material, findToolOrArmor(material, discription + "_leggins"));
		createBoots(consumer, material, findToolOrArmor(material, discription + "_boots"));
	}

	private void create9Recipe(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder recipe = ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.patternLine("###").patternLine("###").patternLine("###").addCriterion("hasItem", hasItem(material));
		recipe.build(consumer);
	}

	private void create9Recipe(Consumer<IFinishedRecipe> consumer, Item material, Item result, String saveAddition) {
		ShapedRecipeBuilder recipe = ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.patternLine("###").patternLine("###").patternLine("###").addCriterion("hasItem", hasItem(material));
		recipe.build(consumer, Registry.ITEM.getKey(result) + saveAddition);
	}

	private void create4Recipe(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material)).patternLine("## ")
				.patternLine("## ").addCriterion("hasItem", hasItem(material)).build(consumer);
	}
	private void create4Recipe(Consumer<IFinishedRecipe> consumer, Item material, Item result, int count) {
		ShapedRecipeBuilder.shapedRecipe(result, count).key('#', Ingredient.fromItems(material)).patternLine("## ")
				.patternLine("## ").addCriterion("hasItem", hasItem(material)).build(consumer);
	}

	/**
	 * 
	 * @param consumer
	 * @param material    - the material the tools should be crafted with
	 * @param discription i added to the tool name like materil_discription_ToolType
	 */
	private void createToolRecipes(Consumer<IFinishedRecipe> consumer, Item material, String discription) {
		createAxe(consumer, material, findToolOrArmor(material, discription + "_axe"));
		createPickaxe(consumer, material, findToolOrArmor(material, discription + "_pickaxe"));
		createSword(consumer, material, findToolOrArmor(material, discription + "_sword"));
		createShovel(consumer, material, findToolOrArmor(material, discription + "_shovel"));
		createHoe(consumer, material, findToolOrArmor(material, discription + "_hoe"));
	}

	private void createToolRecipes(Consumer<IFinishedRecipe> consumer, Item material) {
		createAxe(consumer, material, findToolOrArmor(material, "axe"));
		createPickaxe(consumer, material, findToolOrArmor(material, "pickaxe"));
		createSword(consumer, material, findToolOrArmor(material, "sword"));
		createShovel(consumer, material, findToolOrArmor(material, "shovel"));
		createHoe(consumer, material, findToolOrArmor(material, "hoe"));
	}

	private Item findToolOrArmor(Item material, String addition) {
		String path = material.getRegistryName().getPath();
		return ItemInit.getItemByRegistryName(path.substring(0, path.indexOf("_") + 1) + addition);
	}

	private void createHelmet(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material)).patternLine("###")
				.patternLine("# #").addCriterion("hasItem", hasItem(material)).build(consumer);
	}

	private void createChestplate(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material)).patternLine("# #")
				.patternLine("###").patternLine("###").addCriterion("hasItem", hasItem(material)).build(consumer);
	}

	private void createLeggings(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material)).patternLine("###")
				.patternLine("# #").patternLine("# #").addCriterion("hasItem", hasItem(material)).build(consumer);
	}

	private void createBoots(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material)).patternLine("# #")
				.patternLine("# #").addCriterion("hasItem", hasItem(material)).build(consumer);
	}

	private void createAxe(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		String path = material.getRegistryName().getPath();
		String materialName = path.substring(0, path.indexOf("_"));
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.key('|', Ingredient.fromItems(Items.STICK)).patternLine("## ").patternLine("#| ").patternLine(" | ")
				.addCriterion("hasItem" + materialName, hasItem(material)).build(consumer);
		;
	}

	private void createPickaxe(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		String path = material.getRegistryName().getPath();
		String materialName = path.substring(0, path.indexOf("_"));
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.key('|', Ingredient.fromItems(Items.STICK)).patternLine("###").patternLine(" | ").patternLine(" | ")
				.addCriterion("hasItem" + materialName, hasItem(material)).build(consumer);
		;
	}

	private void createSword(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		String path = material.getRegistryName().getPath();
		String materialName = path.substring(0, path.indexOf("_"));
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.key('|', Ingredient.fromItems(Items.STICK)).patternLine(" # ").patternLine(" # ").patternLine(" | ")
				.addCriterion("hasItem" + materialName, hasItem(material)).build(consumer);
		;
	}

	private void createShovel(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		String path = material.getRegistryName().getPath();
		String materialName = path.substring(0, path.indexOf("_"));
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.key('|', Ingredient.fromItems(Items.STICK)).patternLine(" # ").patternLine(" | ").patternLine(" | ")
				.addCriterion("hasItem" + materialName, hasItem(material)).build(consumer);
		;
	}

	private void createHoe(Consumer<IFinishedRecipe> consumer, Item material, Item result) {
		String path = material.getRegistryName().getPath();
		String materialName = path.substring(0, path.indexOf("_"));
		ShapedRecipeBuilder.shapedRecipe(result).key('#', Ingredient.fromItems(material))
				.key('|', Ingredient.fromItems(Items.STICK)).patternLine("## ").patternLine(" | ").patternLine(" | ")
				.addCriterion("hasItem" + materialName, hasItem(material)).build(consumer);
		;
	}

}
