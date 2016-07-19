package me.Jets.Manager;

import static me.Jets.Jets.Jets.jets;
import me.Jets.JetsMain;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RunnableManager {

	private static boolean stop;
	
	public static void StartRunnable(JetsMain plugin) {
		
		stop = false;
		
		new BukkitRunnable() {

			@Override
			public void run() {
				
				for (Player p : jets.keySet()) {
					
				}
				
				if(stop) {
					this.cancel();
				}
				
				
			}
			
		}.runTaskTimer(plugin, 0L, 1L);
	}
	
	public static void StopRunnable() {
		stop = true;
	}

}
