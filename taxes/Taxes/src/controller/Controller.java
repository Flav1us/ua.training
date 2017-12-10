package controller;

import service.TaxCalculator;
import view.View;

public class Controller {
	
//	public String getTotalTax(int personID) {
//		return String.valueOf(TaxCalculator.total(personID));
//	}

	public String getInfo(int person_id) {
		StringBuilder sb = new StringBuilder();
		sb.append(TaxCalculator.total(person_id) + "\n");
		return sb.toString();
	}
}
