package view;

import java.util.List;

public class View {
	private static String IND_FOUND_MESS = "Following indexes found:"; 
	private static String NONE_FOUND_MESS = "No indexes for this number."; 
	
	public void show(List<Integer> values) {
		if(values.isEmpty()) {
			System.out.println(NONE_FOUND_MESS);
			return;
		}
		System.out.println(IND_FOUND_MESS);
		for(int entry : values) {
			System.out.print(entry + "  ");
		}
		System.out.println();
	}
}
