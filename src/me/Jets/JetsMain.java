package me.Jets;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.Jets.Handlers.CommandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class JetsMain extends JavaPlugin {
	
	private static final Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		
		logger.log(Level.INFO, getName() + " version " + getDescription().getVersion()
				+ " is enabled!");
		
	}
	
	public void onDisable() {
		
		logger.log(Level.INFO, getName() + " version " + getDescription().getVersion()
				+ " is disabled!");
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		return CommandHandler.execute(sender, cmd, args);
	}
	
}
