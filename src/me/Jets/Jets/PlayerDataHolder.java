package me.Jets.Jets;

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
}
