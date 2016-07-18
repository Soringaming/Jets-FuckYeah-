package me.Jets;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class JetsMain extends JavaPlugin {
	
	public void onEnable() {
		
		Bukkit.getServer().getLogger().info("Jets Enabled!");
		
	}
	
	public void onDisable() {
		
		Bukkit.getServer().getLogger().info("Jets Disabled!");
		
	}

}
