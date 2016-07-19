package me.Jets.Commands;

public enum Cmnds {
	Jets(AccessType.PLAYER);
	
	private AccessType accessType;
	
	Cmnds(AccessType accessType) {
		this.accessType = accessType;
	}
	
	public AccessType getAccessType() {
		return accessType;
	}
}
