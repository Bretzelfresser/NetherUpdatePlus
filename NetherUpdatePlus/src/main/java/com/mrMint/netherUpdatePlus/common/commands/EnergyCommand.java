package com.mrMint.netherUpdatePlus.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mrMint.netherUpdatePlus.NetherUpdatePlus;
import com.mrMint.netherUpdatePlus.common.items.EnergyItem;
import com.mrMint.netherUpdatePlus.common.items.QuartzBoots;
import com.mrMint.netherUpdatePlus.core.init.ItemInit;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.command.arguments.ItemInput;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;

public class EnergyCommand {

	public static void register(CommandDispatcher<CommandSource> dispacher) {
		LiteralArgumentBuilder<CommandSource> energyCommand = Commands.literal("energy")
				.requires(s -> s.hasPermissionLevel(2))
				.then(Commands.argument("ItemType", ItemArgument.item()).executes(EnergyCommand::executeWithoutValue)
						.then(Commands.argument("EnergyValue", IntegerArgumentType.integer(0)).executes(EnergyCommand::executeWithValue)));
		dispacher.register(energyCommand);
	}

	static int executeWithValue(CommandContext<CommandSource> context) throws CommandSyntaxException {
		System.out.println("yeah");
		if (IntegerArgumentType.getInteger(context, "EnergyValue") >= 3600) {
			executeWithoutValue(context);
		}
		int counter = 0;
		if (context.getSource().asPlayer().inventory.mainInventory != null) {
			for (ItemStack stack : context.getSource().asPlayer().inventory.mainInventory) {
				if (stack.getItem() instanceof EnergyItem && stack.getItem().equals(ItemArgument.getItem(context, "ItemType").getItem())) {
					EnergyItem item = (EnergyItem) stack.getItem();
					item.setEnergy(stack, IntegerArgumentType.getInteger(context, "EnergyValue"));
					counter++;
				}
			}
		}
		if (context.getSource().getEntity().getArmorInventoryList() != null) {
			for (ItemStack stack : context.getSource().getEntity().getArmorInventoryList()) {
				if (stack.getItem() instanceof EnergyItem && stack.getItem().equals(ItemArgument.getItem(context, "ItemType").getItem())) {
					EnergyItem item = (EnergyItem) stack.getItem();
					item.setEnergy(stack, IntegerArgumentType.getInteger(context, "EnergyValue"));
					counter++;
				}
			}
		}
		sendMessage(context, counter, IntegerArgumentType.getInteger(context, "EnergyValue"));
		return 1;
	}

	static int executeWithoutValue(CommandContext<CommandSource> context) throws CommandSyntaxException {
		int counter = 0;
		if (context.getSource().asPlayer().inventory.mainInventory != null) {
			for (ItemStack stack : context.getSource().asPlayer().inventory.mainInventory) {
				if (stack.getItem() instanceof EnergyItem && stack.getItem().equals(ItemArgument.getItem(context, "ItemType").getItem())) {
					EnergyItem i = (EnergyItem) stack.getItem();
					i.setEnergy(stack, i.getMaxEnergy(stack));
					counter++;
				}
			}
		}
		if (context.getSource().getEntity().getArmorInventoryList() != null) {
			for (ItemStack stack : context.getSource().getEntity().getArmorInventoryList()) {
				if (stack.getItem() instanceof EnergyItem && stack.getItem().equals(ItemArgument.getItem(context, "ItemType").getItem())) {
					EnergyItem item = (EnergyItem) stack.getItem();
					item.setEnergy(stack, item.getMaxEnergy(stack));
					counter++;
				}
			}
		}
		sendMessage(context, counter, 3600);
		return 1;
	}

	static void sendMessage(CommandContext<CommandSource> context, int counter, int energyValue) {
		if (energyValue < 3600) {
			context.getSource().sendFeedback(new TranslationTextComponent(
					"command." + NetherUpdatePlus.MODID + ".energySet", energyValue, counter), false);
		} else {
			context.getSource().sendFeedback(
					new TranslationTextComponent("command." + NetherUpdatePlus.MODID + ".energySet2", counter), false);
		}
	}

}
