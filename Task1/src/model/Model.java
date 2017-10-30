package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	public List<Integer> findIndexes(int[] sourceArr, int intToFind) {
		List<Integer> indexes = new ArrayList<>();
		for(int i = 0; i < sourceArr.length; i++) {
			if(sourceArr[i] == intToFind) {
				indexes.add(i);
			}
		}
		return indexes;
	}
}
