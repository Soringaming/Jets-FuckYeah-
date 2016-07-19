package me.Jets.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class JetsHelp implements CommandBase {

	@Override
	public void run(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GOLD + "Jets is a dog fight plugin! It allows you to fly through the air with elytra, and also gives you weapons to shoot others down!");
		
	}

}
