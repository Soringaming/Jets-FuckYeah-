package me.Jets.Commands;

public enum AccessType {
	PLAYER("players"),
	CONSOLE("the console"),
	EITHER("");
	
	public String title;
	
	AccessType(String title) {
		this.title = title;
	}
}
