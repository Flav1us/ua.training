package model;

import controller.Validator;

public class Account {
	private String first_name;
	private String last_name;
	private String nick_name;
	
	public Account(String first_name, String last_name, String nick_name) {
		setValidFirstName(first_name);
		setValidLastName(last_name);
		setValidNickName(nick_name);
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
	
	public void setValidFirstName(String first_name) throws IllegalArgumentException {
		if(!Validator.isFirstNameValid(first_name)) {
			throw new IllegalArgumentException();
		}
		else {
			this.first_name = first_name;			
		}
	}
	
	public void setValidLastName(String last_name) throws IllegalArgumentException {
		if(!Validator.isLastNameValid(last_name)) {
			throw new IllegalArgumentException();
		}
		else {
			this.last_name = last_name;
		}
	}
	
	public void setValidNickName(String nick_name) throws IllegalArgumentException {
		if(!Validator.isNickNameValid(nick_name)) {
			throw new IllegalArgumentException();
		}
		else {
			this.nick_name = nick_name;
		}
	}
}
