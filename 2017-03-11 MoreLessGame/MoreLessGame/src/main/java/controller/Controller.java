package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

import model.Bounds;
import view.View;

public class Controller {
	static String WELCOME				 = "Try to find the number between %d and %d. Suggest variant: ";
	static String NOT_IN_BOUNDS			 = "Out of bounds. Try integers between %d and %d.";
	
	static String NOT_INTEGER_TRY_AGAIN	 = "Wrong input type. Try integers.";
	static String RESTARTING_SCANNER	 = "Internal error occured. Restarting scanner...";
	static String CONGRATULATE			 = "Congratulations! You won!";
	static String MORE					 = "more";
	static String LESS					 = "less";
	static String WANT_NEW_GAME			 = "New game? [Y/N]";
	
	static final Bounds default_bounds = new Bounds(0, 100);
	
	private static Scanner inputSource;
	
	static {
		resetScanner();
	}
	
	public static void play(int min_bound, int max_bound) {
	}
	
	public static void play() {
		do {
		playOneGame();
		} while (wantAnotherGame());
	}

	public static void playOneGame() {
		View.format(WELCOME, default_bounds.getMin(), default_bounds.getMax()); 
		//View.print(WELCOME);
		Game game = new Game();
		while(!game.isWon()) {
			int suggestion = getValidInput(game.bounds); 
			game.doRound(suggestion);
			game.updateResults(suggestion);
		}
		View.print(CONGRATULATE);
		View.printResults(game.getResults());
	}
	
	private static boolean wantAnotherGame() {
		View.print(WANT_NEW_GAME);
		String response = inputSource.next("[YNyn]");
		if (response.equals("Y") || response.equals("y")) {
			return true;
		}
		else return false;
	}
	
	private static int getValidInput(Bounds bounds) {
		int suggestion = getInteger(bounds);
		return suggestion;
	}
	
	private static int getInteger(Bounds bounds) {
		int suggestion = 0;
		while(true) {
			try {
				suggestion = inputSource.nextInt();
				if(isInBounds(suggestion, bounds)) {
					break;
				}
				else {
					View.format(NOT_IN_BOUNDS, bounds.getMin(), bounds.getMax());
					//View.print(NOT_IN_BOUNDS);
				}
			}
			catch (InputMismatchException me) {
				View.print(NOT_INTEGER_TRY_AGAIN);
				resetScanner();
			}
			catch (Exception e) {
				View.print(RESTARTING_SCANNER);
				resetScanner();
			}
		}
		return suggestion;
	}
	
	public static boolean isInBounds(int arg, Bounds bounds) {
		if (arg <= bounds.getMax() && arg >= bounds.getMin()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void resetScanner() {
		inputSource = new Scanner(System.in, "UTF-8");
	}
	
	protected void finalize() {
		inputSource.close();
	}
}
