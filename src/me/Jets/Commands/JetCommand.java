package me.Jets.Commands;

import static me.Jets.Jets.Jets.jets;
import me.Jets.Jets.Jet;
import me.Jets.Jets.PlayerDataHolder;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JetCommand implements CommandBase{
	public void run(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		if (jets.containsKey(player)) {
			// Un-jet
			jets.remove(player);
			PlayerDataHolder.restoreData(player);
		} else {
			Jet jet = new Jet(player, PlayerDataHolder.loadData(player));
			jets.put(player, jet);
			player.sendMessage("Woosh!");
			
		}
	}
}
