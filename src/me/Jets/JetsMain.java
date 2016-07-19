package me.Jets;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Jets.Handlers.CommandHandler;
import me.Jets.Manager.RunnableManager;

public class JetsMain extends JavaPlugin {
	
	private static final Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		
		logger.log(Level.INFO, getName() + " version " + getDescription().getVersion()
				+ " is enabled!");

		for (Listener l : new Listener[] {
				// TODO List events in here
				}) {
			getServer().getPluginManager().registerEvents(l, this);
		}
		
		RunnableManager.StartRunnable();
		
	}
	
	public void onDisable() {
		
		logger.log(Level.INFO, getName() + " version " + getDescription().getVersion()
				+ " is disabled!");
		
		RunnableManager.StopRunnable();
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		return CommandHandler.execute(sender, cmd, args);
	}
	
}