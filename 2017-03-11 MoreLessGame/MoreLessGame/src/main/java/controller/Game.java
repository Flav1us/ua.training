package controller;

import java.util.LinkedList;
import java.util.List;

import model.Bounds;
import model.Model;
import view.View;

public class Game {
	public Bounds bounds = new Bounds(Controller.default_bounds.getMin(), Controller.default_bounds.getMax());
	private int target;
	private boolean won = false;
	private Results results = new Results();
	
	public Game() {
		//System.out.println(bounds.getMin() + "\t" + bounds.getMax());
		this.target = Model.rand(bounds);
	}
	
	public Game(Bounds bounds) {
		this.bounds = bounds;
		this.target = Model.rand(bounds);
	}
	
	public void doRound(int suggestion) {
		//results.update(suggestion); in Controller
		int direction = Model.whereToGo(suggestion, target, bounds);
		if(direction == 0) {
			won = true;
		}
		else if (direction == Model.LEFT) {
			bounds.setMax(suggestion);
			View.print(Controller.LESS);
		}
		else if (direction == Model.RIGHT) {
			bounds.setMin(suggestion);
			View.print(Controller.MORE);
		}
	}
	
	public Results getResults() {
		return results;
	}
	
	public boolean isWon() {
		return won;
	}

	public void updateResults(int suggestion) {
		results.update(suggestion);
	}

}
