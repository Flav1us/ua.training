package model;

public class Account {
	private String first_name;
	private String last_name;
	private String nick_name;
	
	public Account(String first_name, String last_name, String nick_name) {
		setFirstName(first_name);
		setLastName(last_name);
		setNickName(nick_name);
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return last_name;
	}
	
	public String getNickName() {
		return nick_name;
	}
	
	public void setFirstName(String first_name) throws IllegalArgumentException {
		this.first_name = first_name;			
	}
	
	public void setLastName(String last_name) throws IllegalArgumentException {
		this.last_name = last_name;
	}
	
	public void setNickName(String nick_name) throws IllegalArgumentException {
		this.nick_name = nick_name;
	}
}
