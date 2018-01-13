package services;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import entity.Coordinates;

public class TestCoordinates {
	@Test
	public void Test() {
		Coordinates coord1 = new Coordinates(50, 30.5);
		Coordinates coord2 = new Coordinates(52, 32);
		System.out.println(Math.abs(CoordinatesService.calculateDistance(coord1, coord2) - 3.2));
		assertTrue(Math.abs(CoordinatesService.calculateDistance(coord1, coord2) - 3.2) < 0.01 );
	}
}
