package com.mrMint.netherUpdatePlus.world;

import com.mrMint.netherUpdatePlus.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

	public static void generateOres(final BiomeLoadingEvent event) {
		if (event.getCategory().equals(Biome.Category.NETHER)) {
			generateTungsten(event);
			generateTanzanite(event);
		}
	}

	private static void generateOre(final BiomeGenerationSettingsBuilder settings, final RuleTest fillerType,
			final BlockState state, final int veinSize, final int minHeight, final int maxHeight,
			final int MaxAmountPerChunk) {
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))
								.square().func_242731_b(MaxAmountPerChunk)));
	}
	
	private static void generateTanzanite(final BiomeLoadingEvent event) {
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
				BlockInit.TANZANITE_ORE.get().getDefaultState(), 3, 70, 120, 70);
	}
	
	private static void generateTungsten(final BiomeLoadingEvent event) {
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.BLACK_TUNGSTEN_SHADOW.get().getDefaultState(), 2, 5, 100, 50);
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.SILVER_TUNGSTEN_SHADOW.get().getDefaultState(), 2, 5, 100, 50);
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.ORANGE_TUNGSTEN_SHADOW.get().getDefaultState(), 2, 5, 100, 50);
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.BLACK_TUNGSTEN_SHADOW.get().getDefaultState(), 4, 100, 120, 70);
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.SILVER_TUNGSTEN_SHADOW.get().getDefaultState(), 4, 100, 120, 70);
		generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK,
				BlockInit.ORANGE_TUNGSTEN_SHADOW.get().getDefaultState(), 4, 100, 120, 70);
	}

}
