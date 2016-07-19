package me.Jets.Handlers;

import me.Jets.Commands.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {
	public static boolean execute(CommandSender sender, Command cmd,
			String[] args) {

		String label = cmd.getLabel();
		
		Cmd.runCmd(sender, args, label);
		
		return false;
	}

}
