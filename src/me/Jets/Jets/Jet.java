package me.Jets.Jets;

import me.Jets.Util.MeasurementPreference;
import me.Jets.Util.Speed;

import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class Jet {

	public static double maxSpeed = 2;
	public static double maxAccel = .02;

	public Player player;
	public PlayerDataHolder playerDataHolder;

	public MeasurementPreference mPreference = MeasurementPreference.MPH;

	public float fuel;
	public float mGun;
	public int missiles;
	public int flares;
	public int bombs;

	public int maxMissiles;
	public int maxFlares;
	public int maxBombs;

	public BossBar fuelBar;
	public BossBar mGunAmmoBar;
	public BossBar missileAmmoBar;
	public BossBar flaresBar;
	public BossBar bombsBar;

	public Location previousLoc;
	public Speed speed = new Speed();

	Jet(Player player, PlayerDataHolder playerDataHolder) {
		this.player = player;
		this.playerDataHolder = playerDataHolder;

		setBar(fuelBar, "§7Fuel", 1d, BarColor.WHITE, BarStyle.SOLID, true);
		setBar(mGunAmmoBar, "§bMachine Gun", 1d, BarColor.BLUE, BarStyle.SOLID,
				false);
		setBar(missileAmmoBar, "§aMissiles", 1d, BarColor.GREEN,
				BarStyle.SEGMENTED_10, false);
		setBar(flaresBar, "§cFlares", 1d, BarColor.RED, BarStyle.SEGMENTED_6,
				false);
		setBar(bombsBar, "§dBombs", 1d, BarColor.PURPLE, BarStyle.SEGMENTED_12,
				false);
	}

	public void update() {
		updateBars();
		updateSpeedometer();
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
