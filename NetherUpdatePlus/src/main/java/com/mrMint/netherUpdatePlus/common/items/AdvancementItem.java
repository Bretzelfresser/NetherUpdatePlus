package com.mrMint.netherUpdatePlus.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class AdvancementItem extends Item {

	public AdvancementItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);
		world.playSound(null, player.getPosition(), SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 100f, 0.1f);
		world.playSound(null, player.getPosition(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.MASTER, 100f,
				0.1f);
		if (world.isRemote)
			player.sendMessage(new TranslationTextComponent("netherupdateplus.hoe_message"),
					player.getUniqueID());
		stack = ItemStack.EMPTY;
		return ActionResult.resultConsume(stack);
	}

}
