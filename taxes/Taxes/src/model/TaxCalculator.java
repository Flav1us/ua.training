package model;

import java.util.HashMap;
import java.util.Map;

import db_mysql.DBAccess;
import db_mysql.IncomeType;

public class TaxCalculator {
	
	public static double total(int personID) {
		Map<IncomeType, Double> taxes = getTaxes(personID);
		double sum = 0;
		for(Map.Entry<IncomeType, Double> e : taxes.entrySet()) {
			sum += e.getValue();
		}
		return sum;
	}
	
	public static Map<IncomeType, Double> getTaxes(int personID) {
		Map<IncomeType, Double> taxes = new HashMap<>();
		Map<IncomeType, Double> income = DBAccess.getIncome(personID);
		income.forEach((inc_type, amount) -> taxes.merge(inc_type, calculate(inc_type, amount), Double::sum));
		return taxes;
	}
	
	private static double calculate(IncomeType type, double amount) {
		return amount * type.getTaxRate();
	}
	
}
