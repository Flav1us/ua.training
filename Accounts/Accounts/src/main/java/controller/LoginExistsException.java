package controller;

public class LoginExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	String first_name;
	String last_name;
	
	public LoginExistsException(String suggested_first_name, String suggested_last_name) {
		this.first_name = suggested_first_name;
		this.last_name = suggested_last_name;
	}
}
