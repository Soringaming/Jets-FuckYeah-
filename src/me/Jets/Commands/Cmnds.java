package me.Jets.Commands;

public enum Cmnds {
	JETS("jets", AccessType.PLAYER, new JetCommand());
	
	private String label;
	private AccessType accessType;
	public CommandBase command;
	
	Cmnds(String label, AccessType accessType, CommandBase command) {
		this.accessType = accessType;
		this.command = command;
	}
	
	public String getLabel() {
		return label;
	}
	
	public AccessType getAccessType() {
		return accessType;
	}
}
