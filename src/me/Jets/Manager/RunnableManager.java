package me.Jets.Manager;

import org.bukkit.scheduler.BukkitRunnable;

import me.Jets.JetsMain;

public class RunnableManager {

	private static boolean stop;
	
	public static void StartRunnable() {
		
		stop = false;
		
		new BukkitRunnable() {

			@Override
			public void run() {
				if(stop) {
					this.cancel();
				}
				
				
			}
			
		}.runTaskTimer(new JetsMain(), 0L, 1L);
	}
	
	public static void StopRunnable() {
		stop = true;
	}
}
