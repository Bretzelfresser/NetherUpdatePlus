package com.mrMint.netherUpdatePlus.data.client;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class Tags {
	
	public static final class Blocks{
		public static final ITag.INamedTag<Block> NYLUIM_BLOCK = createModTag("nylium_blocks");
		
		public static ITag.INamedTag<Block> createModTag(String name){
			return BlockTags.makeWrapperTag(new ResourceLocation(NetherUpdatePlus.MODID, name).toString());
		}
		
		
	}
	
	public static final class Items{
		
	}

}
