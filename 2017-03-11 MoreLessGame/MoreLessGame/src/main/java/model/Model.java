package model;

import java.util.Random;

import controller.Game;
import view.View;

public class Model {
	public static final int RAND_MAX = 100;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	
	public static int rand(int min, int max) {
		int shifted_random = new Random().nextInt(max - min + 1);
		return shifted_random + min;
	}
	
	public static int rand(Bounds bounds) {
		return Model.rand(bounds.getMin(), bounds.getMax());
	}
	
	public static int rand() {
		return Model.rand(0, RAND_MAX);
	}
	
	public static int whereToGo(int suggestion, int target, Bounds bounds) {
		if(target < suggestion) {
			return LEFT;
		}
		else if(target > suggestion) {
			return RIGHT;
		}
		else {
			return 0;
		}
	}
}
