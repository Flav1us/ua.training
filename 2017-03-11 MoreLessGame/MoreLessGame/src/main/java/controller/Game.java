package controller;

import java.util.LinkedList;
import java.util.List;

import model.Bounds;
import model.Model;
import view.View;

public class Game {
	private int target;
	private List<Integer> suggested = new LinkedList<>();
	private boolean win = false;
	public static Bounds bounds = new Bounds(0, 100);
	
	public Game() {
		this.target = Model.rand(Game.bounds);
	}
	
	public void doRound(int suggestion) {
		suggested.add(suggestion);
		int direction = Model.whereToGo(suggestion, target, bounds);
		if(direction == 0) {
			win = true;
		}
		else if (direction == Model.LEFT) {
			bounds.setMax(suggestion);
			View.print(Controller.LESS);
		}
		else {
			bounds.setMin(suggestion);
			View.print(Controller.MORE);
		}
	}
	
	public boolean isWon() {
		return win;
	}

}
