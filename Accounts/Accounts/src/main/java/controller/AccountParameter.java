package controller;

public enum AccountParameter {
	FIRST_NAME("first_name"),
	LAST_NAME("last_name"),
	NICK_NAME("nick_name");
	
	private String stringValue;
	private AccountParameter(String name) {
		this.stringValue = name;
	}
	
	public String toString() {
		return this.stringValue;
	}
}
