package me.Jets.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.Jets.JetsMain;
import me.Jets.Particles.ParticleAnimation;

public class JetsHelp implements CommandBase {

	@Override
	public void run(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GOLD + "Jets is a dog fight plugin! It allows you to fly through the air with elytra, and also gives you weapons to shoot others down!");
		Player player = null;
		if(sender instanceof Player) {
			player = (Player) sender;
		}
		final Location loc = player.getLocation();
		new BukkitRunnable() {

			@Override
			public void run() {
				double t = 0;
				t = t + 0.2;
				if(t > 20) {
					this.cancel();
				}
				ParticleAnimation.doRadialWave(loc, "CLOUD", 32, 3, 0.2, 0.2, -0.3, 20, 0.5F, 0.5F, 0.5F, 0.01F, 1, 300);
				
			}
			
		}.runTaskTimer(new JetsMain(), 0, 1);
	}

}
