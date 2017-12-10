import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import entity.IncomeType;
import service.TaxCalculator;

public class TestTaxCalculator {
	@Test
	public void test() {
		Map<IncomeType, Double> taxes = TaxCalculator.getTaxes(1);
		assertTrue(taxes.get(IncomeType.primary_job).equals(3600.0));
		assertTrue(taxes.get(IncomeType.secondary_job).equals(900.0));
		System.out.println(taxes.toString());
		System.out.println(TaxCalculator.total(1));
	}
}
