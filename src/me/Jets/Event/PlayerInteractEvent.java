package me.Jets.Event;

import static me.Jets.Jets.Jets.jets;

import org.bukkit.Material;
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
		
		if (!action.equals(Action.LEFT_CLICK_AIR))
			return;
		
		ItemStack item = event.getItem();
		
		if (item.getType().equals(Material.STONE_BUTTON)) {
			
		}
	}
}
