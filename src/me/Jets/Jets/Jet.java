package me.Jets.Jets;

<<<<<<< HEAD
import me.Jets.Util.MeasurementPreference;
import me.Jets.Util.Speed;

import org.bukkit.Bukkit;
=======
>>>>>>> origin/master
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Jets.Util.MeasurementPreference;
import me.Jets.Util.Speed;

public class Jet {

	public static double maxSpeed = 2;
	public static double maxAccel = .02;

	public Player player;
	public PlayerDataHolder playerDataHolder;

	public MeasurementPreference mPreference = MeasurementPreference.MPH;

	public float fuel = 1;
	public float mGun = 1;
	public int missiles = 10;
	public int flares = 6;
	public int bombs = 12;

	public int maxMissiles = 10;
	public int maxFlares = 6;
	public int maxBombs = 12;

	public BossBar fuelBar = Bukkit.createBossBar("§7Fuel", BarColor.WHITE,
			BarStyle.SOLID);
	public BossBar mGunAmmoBar = Bukkit.createBossBar("§bMachine Gun",
			BarColor.BLUE, BarStyle.SOLID);
	public BossBar missileAmmoBar = Bukkit.createBossBar("§aMissiles",
			BarColor.GREEN, BarStyle.SEGMENTED_10);
	public BossBar flaresBar = Bukkit.createBossBar("§cFlares", BarColor.RED,
			BarStyle.SEGMENTED_6);
	public BossBar bombsBar = Bukkit.createBossBar("§dBombs", BarColor.PURPLE,
			BarStyle.SEGMENTED_12);

	public Location previousLoc;
	public Speed speed = new Speed();

	public Jet(Player player, PlayerDataHolder playerDataHolder) {
		this.player = player;
		this.playerDataHolder = playerDataHolder;
		previousLoc = player.getLocation();
		
		fuelBar.addPlayer(player);
		mGunAmmoBar.addPlayer(player);
		missileAmmoBar.addPlayer(player);
		flaresBar.addPlayer(player);
		bombsBar.addPlayer(player);

		setBar(fuelBar, "§7Fuel", 1d, BarColor.WHITE, BarStyle.SOLID, true);
		setBar(mGunAmmoBar, "§bMachine Gun", 1d, BarColor.BLUE, BarStyle.SOLID,
				false);
		setBar(missileAmmoBar, "§aMissiles", 1d, BarColor.GREEN,
				BarStyle.SEGMENTED_10, false);
		setBar(flaresBar, "§cFlares", 1d, BarColor.RED, BarStyle.SEGMENTED_6,
				false);
		setBar(bombsBar, "§dBombs", 1d, BarColor.PURPLE, BarStyle.SEGMENTED_12,
				false);
		
		player.setVelocity(player.getEyeLocation().getDirection().setY(10));
		
		player.getInventory().clear();
		player.getInventory().setChestplate(new ItemStack(Material.ELYTRA, 1));
		player.getInventory().setItem(0, new ItemStack(Material.STONE_BUTTON, 1));
		player.updateInventory();
	}

	public void update() {
		player.setGliding(true);
		updateBars();
		updateSpeedometer();
		
		if (player.isSneaking() && !((HumanEntity) player).isOnGround()) {
			player.setVelocity(player.getVelocity().add(
					player.getEyeLocation().getDirection().multiply(maxAccel)));
			fuel -= 0.001;
		}
		
		if (player.getVelocity().length() > maxSpeed) {
			double mult = maxSpeed / player.getVelocity().length();
			player.setVelocity(player.getVelocity().multiply(mult));
		}
		
		previousLoc = player.getLocation();
	}

	public void updateBars() {
		fuelBar.setProgress(fuel);
		mGunAmmoBar.setProgress(mGun);
		missileAmmoBar.setProgress((double) missiles / (double) maxMissiles);
		flaresBar.setProgress((double) flares / (double) maxFlares);
		bombsBar.setProgress((double) bombs / (double) maxBombs);

		switch (player.getInventory().getItemInMainHand().getType()) {
		case STONE_BUTTON:
			mGunAmmoBar.setVisible(true);
			missileAmmoBar.setVisible(false);
			flaresBar.setVisible(false);
			bombsBar.setVisible(false);
			break;
		case MONSTER_EGG:
			mGunAmmoBar.setVisible(false);
			missileAmmoBar.setVisible(true);
			flaresBar.setVisible(false);
			bombsBar.setVisible(false);
			break;
		case FIREWORK:
			mGunAmmoBar.setVisible(false);
			missileAmmoBar.setVisible(false);
			flaresBar.setVisible(true);
			bombsBar.setVisible(false);
			break;
		case TNT:
			mGunAmmoBar.setVisible(false);
			missileAmmoBar.setVisible(false);
			flaresBar.setVisible(false);
			bombsBar.setVisible(true);
		default:
			mGunAmmoBar.setVisible(false);
			missileAmmoBar.setVisible(false);
			flaresBar.setVisible(false);
			bombsBar.setVisible(false);
			break;
		}
	}

	public void updateSpeedometer() {
		double dist = previousLoc.distance(player.getLocation());
		speed.setMetersPerTick(dist);
		switch (mPreference) {
		case KPH:
			player.setLevel((int) speed.getKilometersPerHour(speed));
			break;
		case MPH:
			player.setLevel((int) speed.getMilesPerHour(speed));
			break;
		default:
			break;
		}
	}

	private void setBar(BossBar bar, String title, double progress,
			BarColor color, BarStyle style, boolean visible) {
		bar.setTitle(title);
		bar.setProgress(progress);
		bar.setColor(color);
		bar.setStyle(style);
		bar.setVisible(visible);
	}
}
