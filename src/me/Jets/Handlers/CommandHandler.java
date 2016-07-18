package me.Jets.Handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {
	public static boolean execute(CommandSender sender, Command cmd,
			String[] args) {

		String label = cmd.getLabel();

		switch (label) {
		case "whatever":
			// TODO Run whatever command
			return true;
		case "other":
			// TODO Run other command idk
			return true;
		default:
			return false;
		}
	}
}
