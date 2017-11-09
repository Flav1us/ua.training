package controller;

import java.util.regex.Pattern;

public class Validator {
	public static boolean isFirstNameValid(String first_name) {
		String regexp_first_name = StringConstants.getString("regexp.first_name");
		return Pattern.matches(regexp_first_name, first_name);
	}
	
	public static boolean isLastNameValid(String last_name) {
		String regexp_last_name = StringConstants.getString("regexp.last_name");
		return Pattern.matches(regexp_last_name, last_name);
	}
	
	public static boolean isNickNameValid(String nick_name) {
		String regexp_nick_name = StringConstants.getString("regexp.nick_name");
		return Pattern.matches(regexp_nick_name, nick_name);
	}
}
