import org.junit.Test;

import db_mysql.IncomeType;
import model.TaxSorter;
import model.TaxCalculator;

import static org.junit.Assert.*;

import java.util.Map;

public class TestTaxSorting {
	@Test
	public void test() {
		Map<IncomeType, Double> taxes = TaxCalculator.getTaxes(1);
		System.out.println(taxes.toString());
		System.out.println(TaxSorter.sort(taxes).toString());
	}
}
