package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

import model.Bounds;
import view.View;

public class Controller {
	//TODO вариативные границы и рефакторинг и кучу всего
	static String WELCOME = "Try to find the number between 0 and 100. Suggest variant: ";
	static String NOT_INTEGER_TRY_AGAIN = "Wrong input type. Try integers between 0 and 100.";
	static String RESTARTING_SCANNER = "Internal error occured. Restarting scanner...";
	static String NOT_IN_BOUNDS = "Suggested number is out of bounds. Try integers between 0 and 100.";
	static String CONGRATULATE = "Congratulations! You won!";
	static String MORE = "more";
	static String LESS = "less";
	static String WANT_NEW_GAME = "New game? [Y/N]";
	private static Scanner inputSource = getSystemScanner();
	
	public static void play(int min_bound, int max_bound) {
		
	}
	
	public static void play() {
		View.print(WELCOME);
		Game game = new Game();
		while(!game.isWon()) {
			game.doRound(getValidInput());
		}
		View.print(CONGRATULATE);
		/*View.print("WANT_NEW_GAME");
		if(inputSource.next("[NY]") == "Y") {
			play();
		}*/
	}


	
	private static int getValidInput() {
		int suggestion = getInteger();
		return suggestion;
	}
	
	private static int getInteger() {
		int suggestion = 0;
		while(true) {
			try {
				suggestion = inputSource.nextInt();
				if(isInBounds(suggestion, Game.bounds)) {
					break;
				}
				else {
					View.print(NOT_IN_BOUNDS);
				}
			}
			catch (InputMismatchException me) {
				inputSource = getSystemScanner();
				View.print(NOT_INTEGER_TRY_AGAIN);
			}
			catch (Exception e) {
				View.print(RESTARTING_SCANNER);
				inputSource = getSystemScanner();
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
	
	private static Scanner getSystemScanner() {
		return new Scanner(System.in, "UTF-8");
	}
	
	protected void finalize() {
		inputSource.close();
	}
}
