package me.Jets.Manager;

import static me.Jets.Jets.Jets.jets;

import org.bukkit.scheduler.BukkitRunnable;

import me.Jets.JetsMain;
import me.Jets.Jets.Jet;

public class RunnableManager {

	private static boolean stop;
	
	public static void StartRunnable(JetsMain plugin) {
		
		stop = false;
		
		new BukkitRunnable() {

			@Override
			public void run() {
				
				for (Jet j : jets.values()) {
					j.update();
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
