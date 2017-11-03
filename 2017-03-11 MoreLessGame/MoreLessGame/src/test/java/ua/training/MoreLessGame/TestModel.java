package ua.training.MoreLessGame;

import java.util.Random;

import org.junit.Test;

import junit.framework.Assert;
import model.Bounds;
import model.Model;

public class TestModel {
	/*
	 * Оба теста - вероятностные
	 */
	@Test
	public void testRandInBounds() {
		long startTimer = System.currentTimeMillis();
		Bounds bounds;
		int rand_from_model;
		while(System.currentTimeMillis() < startTimer + 5000) {
			bounds = new Bounds();
			rand_from_model = Model.rand(bounds.getMin(), bounds.getMax());
			Assert.assertTrue("Over max: " + rand_from_model + " > " + bounds.getMax(), rand_from_model <= bounds.getMax());
			Assert.assertTrue("Lower min: " + rand_from_model + " < " + bounds.getMin(), rand_from_model >= bounds.getMin());
		}
	}
	
	@Test
	public void testRandIncludesBounds() {
		long startTimer = System.currentTimeMillis();
		Bounds bounds = new Bounds();
		int rand_from_model;
		int min_count = 0;
		int max_count = 0;
		while(System.currentTimeMillis() < startTimer + 5000) {
			rand_from_model = Model.rand(bounds.getMin(), bounds.getMax());
			if(rand_from_model == bounds.getMin()) {
				min_count++;
			}
			if(rand_from_model == bounds.getMax()) {
				max_count++;
			}
		}
		Assert.assertFalse("No min", min_count == 0);
		Assert.assertFalse("No max", max_count == 0);
	}
	

}
