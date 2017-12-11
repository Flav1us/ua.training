package controller;

import java.util.Map;

import entity.IncomeType;
import service.TaxCalculator;

public class Controller {

	public String getTotal(int person_id) {
		return TaxCalculator.total(person_id) + "\n";
	}
	
	public Map<IncomeType, Double> getAll(int person_id) {
		return TaxCalculator.getTaxes(person_id);
	}
}
