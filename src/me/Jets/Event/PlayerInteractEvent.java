package me.Jets.Event;

import static me.Jets.Jets.Jets.jets;
import me.Jets.Particles.ParticleEffect;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEvent implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onInteract(
			final org.bukkit.event.player.PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if (!jets.containsKey(player))
			return;
		
		Action action = event.getAction();
		
		
		
		ItemStack item = event.getItem();
		
		if (item.getType().equals(Material.STONE_BUTTON)) {
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1, 10);
			
			int dist = 32;
			Location loc = player.getEyeLocation();
			
			Item bullet = player.getWorld().dropItem(loc, new ItemStack(Material.STONE_BUTTON, 1));
			bullet.setGravity(false);
			bullet.setInvulnerable(true);
			bullet.setPickupDelay(1000000);
			for (int i = 0; i < dist * 4; i++) {
				loc.add(player.getEyeLocation().getDirection().multiply(.25));
				bullet.teleport(loc);
				if (bullet.getWorld().getBlockAt(loc).getType().isSolid()) {
					bullet.remove();
					break;
				}
				for (Entity e : bullet.getNearbyEntities(1, 1, 1)) {
					if (e instanceof LivingEntity && !e.equals(player) && !e.equals(bullet)) {
						LivingEntity le = (LivingEntity) e;
						le.damage(4, player);
						bullet.remove();
						break;
					}
				}
			}
		}
	}
}
