package me.Jets.Commands;


public class CommandBase {
	public final AccessType accessType;

	public CommandBase(AccessType accessType) {
		this.accessType = accessType;
	}
}