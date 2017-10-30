package controller;

import java.util.List;

import model.Model;
import view.View;

public class Controller {
	public static int intToFind = 5;
	private static final int[] sourceArr = {3, 5, 4, 1, 5, 6, 2, 4, 8, 7, 4, 1, 10, 0 ,9};
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void search() {
		List<Integer> indexes = model.findIndexes(sourceArr, intToFind);
		view.show(indexes);
	}
	
}
