package services;

import entity.Coordinates;

public class CoordinatesService {

	public static double calculateDistance(Coordinates coord1, Coordinates coord2) {
		return Math.sqrt(Math.pow(coord1.getX() - coord2.getX(), 2) + Math.pow(coord1.getY() - coord2.getY(), 2)) ;
	}

}
