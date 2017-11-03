package model;

import java.util.Random;

public class Bounds {
	private int min;
	private int max;
	
	public Bounds(int min, int max) {
		checkBounds(min, max);
		this.min = min;
		this.max = max;
	}
	
	public Bounds() {
		Random sourceOfRandoms = new Random();
		do {
			this.min = sourceOfRandoms.nextInt(100000);
			this.max = sourceOfRandoms.nextInt(100000);
		} while (this.min > this.max);
	}
	
	public void checkBounds(int min, int max) {
		if(min > max) throw new IllegalArgumentException("Min bounds should be less then max: " + min + " > " + max);
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int newmin) {
		checkBounds(newmin, this.max);
		this.min = newmin;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int newmax) {
		checkBounds(this.min, newmax);
		this.max = newmax;
	}
	
}