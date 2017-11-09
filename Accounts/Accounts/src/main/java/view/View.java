package view;

import controller.StringConstants;

public class View {
	public void print(String message) {
		System.out.println(message);
	}
	
	public void printStored(String key) {
		System.out.println(StringConstants.getString(key));
	}
}
