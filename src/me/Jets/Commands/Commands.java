package me.Jets.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Commands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String labbel, String[] args) {
		
		Player player = (Player) sender; 
		
		String topLines = ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "-------------------" + ChatColor.WHITE + "Jets" + ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "-------------------";
		String bottomLines = ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "-------------------" + ChatColor.WHITE + "Jets" + ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "-------------------";
		
		String jetsInfo = ChatColor.YELLOW + "" + ChatColor.BOLD + "Plugin Version: " + ChatColor.WHITE +  PluginDescriptionFile.getVersion() + "\n"
		+ ChatColor.YELLOW + "" + ChatColor.BOLD + "Author: " + ChatColor.WHITE + getDescription.getAuthors "\n" + ChatColor.YELLOW + "Type " + ChatColor.WHITE + "/Jets Help " + ChatColor.YELLOW "for more information about our plugin.";
		
		
		if (cmd.getName().equalsIgnoreCase("jets") && sender instanceof Player) {
			
			player.sendMessage(topLines);
			player.sendMessage(jetsInfo);
			player.sendMessage(bottomLines);
			
			
			
		}
		return true;
		
	}


}
