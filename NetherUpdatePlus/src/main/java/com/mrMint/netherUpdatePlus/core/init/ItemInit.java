package com.mrMint.netherUpdatePlus.core.init;

import javax.annotation.Nullable;

import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.items.AdvancementItem;
import com.mrMint.netherUpdatePlus.common.items.BlazeBeatsMusicDisk;
import com.mrMint.netherUpdatePlus.common.items.DevItem;
import com.mrMint.netherUpdatePlus.common.items.QuartzBoots;
import com.mrMint.netherUpdatePlus.common.items.TungstenArmor;
import com.mrMint.netherUpdatePlus.core.enums.ModdedArmorMaterial;
import com.mrMint.netherUpdatePlus.core.enums.ModdedToolMaterials;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			NetherUpdatePlus.MODID);
	/**
	 * 
	 * @param name - the name without the modid
	 * @return the Item with the corresponding registry name, or null
	 */
	public static @Nullable Item getItemByRegistryName(String name) {
		for(RegistryObject<Item> i : ITEMS.getEntries()) {
			if(i.get().getRegistryName() != null &&  i.get().getRegistryName().getPath().equals(name)) {
				return i.get();
			}
		}
		return null;
	}
	
	public static final RegistryObject<Item> SOUL_LAVA_BUCKET = ITEMS.register("soul_lava_bucket", () -> new BucketItem(() -> FluidInit.SOUL_LAVA_SOURCE.get(), new Item.Properties().group(NetherUpdatePlus.MISC)));

	public static final RegistryObject<Item> SILVER_TUNGSTEN_INGOT = ITEMS.register("silver_tungsten_ingot",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_INGOT = ITEMS.register("black_tungsten_ingot",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_INGOT = ITEMS.register("orange_tungsten_ingot",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> SILVER_TUNGSTEN_NUGGET = ITEMS.register("silver_tungsten_nugget",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_NUGGET = ITEMS.register("black_tungsten_nugget",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_NUGGET = ITEMS.register("orange_tungsten_nugget",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> TANZANITE_ITEM = ITEMS.register("tanzanite_item",
			() -> new OreItems(new Item.Properties()));
	public static final RegistryObject<Item> TANZANITE_QUARTZ = ITEMS.register("tanzanite_quartz",
			() -> new OreItems(new Item.Properties()));
	public static final RegistryObject<Item> TANZANITE_SHARD = ITEMS.register("tanzanite_shard",
			() -> new OreItems(new Item.Properties()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_SCRAP = ITEMS.register("black_tungsten_scrap",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> SILVER_TUNGSTEN_SCRAP = ITEMS.register("silver_tungsten_scrap",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_SCRAP = ITEMS.register("orange_tungsten_scrap",
			() -> new OreItems(new Item.Properties().isImmuneToFire()));
	public static final RegistryObject<Item> BLAZE_BEATS_DISC = ITEMS.register("blaze_beats_disc",
			() -> new BlazeBeatsMusicDisk(1, SoundInit.BLAZEFUL_BEATS_LAZY,
					new Properties().group(NetherUpdatePlus.MISC).maxStackSize(1).rarity(Rarity.RARE)));
	//ArchievementIcon
	public static final RegistryObject<Item> ARCHIEVEMENT_ICON = ITEMS.register("archievement_hoe_icon",
			() -> new AdvancementItem(new Item.Properties().rarity(Rarity.EPIC).maxStackSize(1)));

	//Tools
	//Tool Properties
	private static Item.Properties getSwordProperties(){
		return new Item.Properties().group(NetherUpdatePlus.COMBAT).isImmuneToFire();
	}
	private static Item.Properties getShovelProperties(){
		return new Item.Properties().group(NetherUpdatePlus.TOOLS).isImmuneToFire();
	}
	
	private static Item.Properties getPickaxeProperties(){
		return new Item.Properties().group(NetherUpdatePlus.TOOLS).isImmuneToFire();
	}
	
	private static Item.Properties getAxeProperties(){
		return new Item.Properties().group(NetherUpdatePlus.TOOLS).isImmuneToFire();
	}
	private static Item.Properties getHoeProperties(){
		return new Item.Properties().group(NetherUpdatePlus.TOOLS).isImmuneToFire();
	}
	
	//Tools Items
		public static final RegistryObject<Item> ORANGE_TUNGSTEN_SWORD = ITEMS.register("orange_tungsten_sword",
				() -> new SwordItem(ModdedToolMaterials.orange_tungsten, 1, -2.4f, getSwordProperties()));
		public static final RegistryObject<Item> ORANGE_TUNGSTEN_SHOVEL = ITEMS.register("orange_tungsten_shovel",
				() -> new ShovelItem(ModdedToolMaterials.orange_tungsten, -2, -3.0f, getShovelProperties()));
		public static final RegistryObject<Item> ORANGE_TUNGSTEN_PICKAXE = ITEMS.register("orange_tungsten_pickaxe",
				() -> new PickaxeItem(ModdedToolMaterials.orange_tungsten, -2, -2.8f, getPickaxeProperties()));
		public static final RegistryObject<Item> ORANGE_TUNGSTEN_AXE = ITEMS.register("orange_tungsten_axe",
				() -> new AxeItem(ModdedToolMaterials.orange_tungsten, 0, -3.1f, getAxeProperties()));
		public static final RegistryObject<Item> ORANGE_TUNGSTEN_HOE = ITEMS.register("orange_tungsten_hoe",
				() -> new HoeItem(ModdedToolMaterials.orange_tungsten, -5, 0, getHoeProperties()));
		
		public static final RegistryObject<Item> BLACK_TUNGSTEN_SWORD = ITEMS.register("black_tungsten_sword",
				() -> new SwordItem(ModdedToolMaterials.black_tungsten, 1, -2.4f, getSwordProperties()));
		public static final RegistryObject<Item> BLACK_TUNGSTEN_SHOVEL = ITEMS.register("black_tungsten_shovel",
				() -> new ShovelItem(ModdedToolMaterials.black_tungsten, -2, -3.0f, getShovelProperties()));
		public static final RegistryObject<Item> BLACK_TUNGSTEN_PICKAXE = ITEMS.register("black_tungsten_pickaxe",
				() -> new PickaxeItem(ModdedToolMaterials.black_tungsten, -2, -2.8f, getPickaxeProperties()));
		public static final RegistryObject<Item> BLACK_TUNGSTEN_AXE = ITEMS.register("black_tungsten_axe",
				() -> new AxeItem(ModdedToolMaterials.black_tungsten, 0, -3.1f, getAxeProperties()));
		public static final RegistryObject<Item> BLACK_TUNGSTEN_HOE = ITEMS.register("black_tungsten_hoe",
				() -> new HoeItem(ModdedToolMaterials.black_tungsten, -5, 0, getHoeProperties()));
		
		public static final RegistryObject<Item> SILVER_TUNGSTEN_SWORD = ITEMS.register("silver_tungsten_sword",
				() -> new SwordItem(ModdedToolMaterials.silver_tungsten, 1, -2.4f, getSwordProperties()));
		public static final RegistryObject<Item> SILVER_TUNGSTEN_SHOVEL = ITEMS.register("silver_tungsten_shovel",
				() -> new ShovelItem(ModdedToolMaterials.silver_tungsten, -2, -3.0f, getShovelProperties()));
		public static final RegistryObject<Item> SILVER_TUNGSTEN_PICKAXE = ITEMS.register("silver_tungsten_pickaxe",
				() -> new PickaxeItem(ModdedToolMaterials.silver_tungsten, -2, -2.8f, getPickaxeProperties()));
		public static final RegistryObject<Item> SILVER_TUNGSTEN_AXE = ITEMS.register("silver_tungsten_axe",
				() -> new AxeItem(ModdedToolMaterials.silver_tungsten, 0, -3.1f, getAxeProperties()));
		public static final RegistryObject<Item> SILVER_TUNGSTEN_HOE = ITEMS.register("silver_tungsten_hoe",
				() -> new HoeItem(ModdedToolMaterials.silver_tungsten, -5, 0, getHoeProperties()));
		
		public static final RegistryObject<Item> DEVELOPER_ITEM = ITEMS.register("developer_item",
				() -> new DevItem(new Properties().rarity(Rarity.EPIC).maxStackSize(1)));
		
	
	// Armor
	// Properties
		private static Item.Properties getHeadArmorProperties(){
			return new Item.Properties().group(NetherUpdatePlus.COMBAT).maxDamage(358).isImmuneToFire();
		}
		private static Item.Properties getBootsArmorProperties(){
			return new Item.Properties().group(NetherUpdatePlus.COMBAT).maxDamage(324).isImmuneToFire();
		}
		private static Item.Properties getLeggingsArmorProperties(){
			return new Item.Properties().group(NetherUpdatePlus.COMBAT).maxDamage(392).isImmuneToFire();
		}
		private static Item.Properties getChestplateArmorProperties(){
			return new Item.Properties().group(NetherUpdatePlus.COMBAT).maxDamage(416).isImmuneToFire();
		}
		
	// ArmorItems
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_HELMET = ITEMS.register("orange_tungsten_helmet",
			() -> new TungstenArmor(ModdedArmorMaterial.OrangeTungsten, EquipmentSlotType.HEAD, getHeadArmorProperties()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_CHESTPLATE = ITEMS.register("orange_tungsten_chestplate",
			() -> new TungstenArmor(ModdedArmorMaterial.OrangeTungsten, EquipmentSlotType.CHEST, getChestplateArmorProperties()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_LEGGINS = ITEMS.register("orange_tungsten_leggins",
			() -> new TungstenArmor(ModdedArmorMaterial.OrangeTungsten, EquipmentSlotType.LEGS, getLeggingsArmorProperties()));
	public static final RegistryObject<Item> ORANGE_TUNGSTEN_BOOTS = ITEMS.register("orange_tungsten_boots",
			() -> new TungstenArmor(ModdedArmorMaterial.OrangeTungsten, EquipmentSlotType.FEET, getBootsArmorProperties()));

	public static final RegistryObject<Item> BLACK_TUNGSTEN_HELMET = ITEMS.register("black_tungsten_helmet",
			() -> new TungstenArmor(ModdedArmorMaterial.BlackTungsten, EquipmentSlotType.HEAD, getHeadArmorProperties()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_CHESTPLATE = ITEMS.register("black_tungsten_chestplate",
			() -> new TungstenArmor(ModdedArmorMaterial.BlackTungsten, EquipmentSlotType.CHEST, getChestplateArmorProperties()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_LEGGINS = ITEMS.register("black_tungsten_leggins",
			() -> new TungstenArmor(ModdedArmorMaterial.BlackTungsten, EquipmentSlotType.LEGS, getLeggingsArmorProperties()));
	public static final RegistryObject<Item> BLACK_TUNGSTEN_BOOTS = ITEMS.register("black_tungsten_boots",
			() -> new TungstenArmor(ModdedArmorMaterial.BlackTungsten, EquipmentSlotType.FEET, getBootsArmorProperties()));

	public static final RegistryObject<Item> SILVER_TUNGSTEN_HELMET = ITEMS.register("silver_tungsten_helmet",
			() -> new TungstenArmor(ModdedArmorMaterial.SilverTungsten, EquipmentSlotType.HEAD, getHeadArmorProperties()));
	public static final RegistryObject<Item> SILVER_TUNGSTEN_CHESTPLATE = ITEMS.register("silver_tungsten_chestplate",
			() -> new TungstenArmor(ModdedArmorMaterial.SilverTungsten, EquipmentSlotType.CHEST, getChestplateArmorProperties()));
	public static final RegistryObject<Item> SILVER_TUNGSTEN_LEGGINS = ITEMS.register("silver_tungsten_leggins",
			() -> new TungstenArmor(ModdedArmorMaterial.SilverTungsten, EquipmentSlotType.LEGS, getLeggingsArmorProperties()));
	public static final RegistryObject<Item> SILVER_TUNGSTEN_BOOTS = ITEMS.register("silver_tungsten_boots",
			() -> new TungstenArmor(ModdedArmorMaterial.SilverTungsten, EquipmentSlotType.FEET, getBootsArmorProperties()));

	public static final RegistryObject<Item> QUARTZ_BOOTS = ITEMS.register("quartz_boots",
			() -> new QuartzBoots(ModdedArmorMaterial.Quartz, EquipmentSlotType.FEET, new Item.Properties().group(NetherUpdatePlus.COMBAT)
					.maxDamage(324)));

	protected static class OreItems extends Item {

		public OreItems(Properties properties) {
			super(properties.group(NetherUpdatePlus.MISC));
		}

	}
}
