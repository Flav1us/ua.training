package entity;

public class Coordinates {

	private double x;
	private double y;

	public Coordinates(double x, double y) {
		if(x < 0 || x > 100 || y < 0 || y > 100) {
			throw new IllegalArgumentException("illegal coordinates: (" + x + "; " + y + "): x, y should be in [0, 100]");
		} else {
			this.x = x;
			this.y = y;
		}
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
