package count_elements;

import java.util.Map;
import java.util.TreeMap;

public class Counter {
	
	public static Map<Integer, Integer> countElements(int[] input) {
		Map<Integer, Integer> count = new TreeMap<>();
		for(Integer i : input) {
			if(!count.containsKey(i)) {
				count.put(i, 0);
			}
			count.put(i, count.get(i) + 1);
		}
		return count;
	}
	
}
