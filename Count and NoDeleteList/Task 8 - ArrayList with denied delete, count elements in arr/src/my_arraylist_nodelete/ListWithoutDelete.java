package my_arraylist_nodelete;

import java.util.ArrayList;
import java.util.List;

public class ListWithoutDelete<T>{
	
	private List<T> container = new ArrayList<>();
	
	public boolean	add(T e) {
		return container.add(e);
	}
	
	public boolean	contains(Object o) {
		return container.contains(o);
	}
	
	public int size() {
		return container.size();
	}
	
	public String toString() {
		return container.toString();
	}
	
	//and so on, but no remove()
}