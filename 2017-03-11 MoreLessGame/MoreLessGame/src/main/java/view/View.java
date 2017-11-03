package view;

import controller.Results;

public class View {
	static String RESULTS = "Your results are: ";
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	public static void format(String message, int min, int max) {
		System.out.format(message+"\n", min, max);
	}
	
	public static void printResults(Results results) {
		print(RESULTS);
		System.out.println(results.getSugestions().size() + " tries:\t" + results.getSugestions().toString());
	}
	
}
