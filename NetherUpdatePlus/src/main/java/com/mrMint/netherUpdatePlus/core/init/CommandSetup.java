package com.mrMint.netherUpdatePlus.core.init;

import com.mrMint.netherUpdatePlus.common.commands.EnergyCommand;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommandSetup {
	
	@SubscribeEvent
	public static void onRegisterCommands(RegisterCommandsEvent event) {
		EnergyCommand.register(event.getDispatcher());
	}

}
