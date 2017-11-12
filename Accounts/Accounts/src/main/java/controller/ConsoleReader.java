package controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.Account;
import view.View;

public class ConsoleReader {

	private static Scanner sc = new Scanner(System.in);
	private static View view;
	
	public ConsoleReader(View view) {
		this.view = view;
	}
	
	public Account getAccount() {
		String first_name = getFromConsole(AccountParameter.FIRST_NAME);
		String last_name = getFromConsole(AccountParameter.LAST_NAME);
		String nick_name = getFromConsole(AccountParameter.NICK_NAME);
		return new Account(first_name, last_name, nick_name);
	}
	
	public String getFromConsole(AccountParameter ap) {
		String param;
		do {
			view.printStored("account.need_"+ap.toString());
			param = sc.nextLine();
			if(isAccParamValid(ap, param)) {
				return param;
			}
			else {
				view.printStored("account.invalid_"+ap.toString());
			}
		} while(true);
	}
	
	public static boolean isAccParamValid(AccountParameter param_name, String parameter) {
		String regex;
		
		switch (param_name) {
		case FIRST_NAME:
			regex = StringConstants.getString("regexp.first_name");
			break;
		case LAST_NAME:
			regex = StringConstants.getString("regexp.last_name");
			break;
		case NICK_NAME:
			regex = StringConstants.getString("regexp.nick_name");
			break;
		default:
			throw new IllegalArgumentException("\"" + param_name + "\" not found in AccountParameter enum");
		}
		
		return Pattern.matches(regex, parameter);
	}
}
