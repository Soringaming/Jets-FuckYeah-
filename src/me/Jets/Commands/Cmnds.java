package me.Jets.Commands;

public enum Cmnds {
	Jets(AccessType.PLAYER, new JetCommand());
	
	private AccessType accessType;
	public CommandBase command;
	
	Cmnds(AccessType accessType, CommandBase command) {
		this.accessType = accessType;
		this.command = command;
	}
	
	public AccessType getAccessType() {
		return accessType;
	}
}
