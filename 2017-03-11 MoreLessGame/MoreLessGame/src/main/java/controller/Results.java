package controller;

import java.util.LinkedList;
import java.util.List;

public class Results {
	private List<Integer> sugestions = new LinkedList<>();
	
	public void update(int suggestion) {
		this.sugestions.add(suggestion);
	}
	
	public List<Integer> getSugestions() {
		return sugestions;
	}
}
