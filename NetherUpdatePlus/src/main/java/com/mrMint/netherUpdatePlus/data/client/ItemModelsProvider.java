package com.mrMint.netherUpdatePlus.data.client;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelsProvider extends ItemModelProvider{

	public ItemModelsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, NetherUpdatePlus.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		basicModel("archievement_hoe_icon");
		basicModel("soul_lava_bucket");
	}
	
	private void basicModel(String name) {
		ModelFile generated = getExistingFile(mcLoc("item/generated"));
		getBuilder(name).parent(generated).texture("layer0", "items/" + name);
		
	}
	
	
	

}
