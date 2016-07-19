package me.Jets.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public enum Cmd {
	JETS("jets", AccessType.PLAYER, new JetCommand());

	private String label;
	private AccessType accessType;
	public CommandBase command;

	Cmd(String label, AccessType accessType, CommandBase command) {
		this.accessType = accessType;
		this.command = command;
	}

	public String getLabel() {
		return label;
	}

	public AccessType getAccessType() {
		return accessType;
	}

	public static Cmd commandFromLabel(String label) {
		for (Cmd cmd : Cmd.values()) {
			if (label.equalsIgnoreCase(cmd.label)) {
				return cmd;
			}
		}

		return null;
	}

	public static void runCmd(CommandSender sender, String[] args, String label) {
		Cmd cmd = commandFromLabel(label);
		if (cmd != null) {
			if (cmd.accessType.equals(AccessType.EITHER)
					|| (sender instanceof Player && cmd.accessType
							.equals(AccessType.PLAYER))
					|| (sender instanceof ConsoleCommandSender && cmd.accessType
							.equals(AccessType.CONSOLE))) {
				cmd.command.run(sender, args);
			} else {
				sender.sendMessage("§cOnly " + cmd.accessType.title
						+ " can use this command!");
			}
		}
	}
}
