package service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import entity.IncomeType;

public class TaxSorter {
	
	public static Map<IncomeType, Double> sort(Map<IncomeType, Double> taxes) {
		return taxes.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
			.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(k, v) -> k,
						LinkedHashMap::new)
		); 
	}
	
}
