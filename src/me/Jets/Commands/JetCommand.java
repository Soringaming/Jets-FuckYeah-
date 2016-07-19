package me.Jets.Commands;

import static me.Jets.Jets.Jets.jets;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Jets.Jets.PlayerDataHolder;

public class JetCommand implements CommandBase{
	public void run(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		if (jets.containsKey(player)) {
			// Un-jet
			jets.remove(player);
			PlayerDataHolder.restoreData(player);
		} else {
			jets.put(player, PlayerDataHolder.loadData(player));
			player.sendMessage("Woosh!");
			
		}
	}
}
