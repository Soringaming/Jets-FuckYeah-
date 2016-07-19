package me.Jets.Jets;

import static me.Jets.Jets.Jets.jets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerDataHolder {
	public float exp;
	public int level;
	public Inventory inv;
	public int foodLevel;
	public float saturation;

	PlayerDataHolder(float exp, int level, Inventory inv, int foodLevel,
			float saturation) {
		this.exp = exp;
		this.level = level;
		this.inv = inv;
		this.foodLevel = foodLevel;
		this.saturation = saturation;
	}

	public static PlayerDataHolder loadData(Player player) {
		return new PlayerDataHolder(player.getExp(), player.getLevel(),
				player.getInventory(), player.getFoodLevel(),
				player.getSaturation());
	}
	
	public static void restoreData(Player player) {
		PlayerDataHolder data = jets.get(player);
		player.setExp(data.exp);
		player.setLevel(data.level);
		player.getInventory().setContents(data.inv.getContents());
		player.setFoodLevel(data.foodLevel);
		player.setSaturation(data.saturation);
	}
}
