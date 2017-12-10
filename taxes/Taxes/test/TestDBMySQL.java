import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import db_mysql.DBAccess;
import entity.IncomeType;

public class TestDBMySQL {
	@Test
	public void testGetByID() {
		Map<IncomeType, Double> inc = DBAccess.getIncome(1);
		assertTrue(inc.get(IncomeType.primary_job) == 20000.0);
		assertTrue(inc.get(IncomeType.secondary_job) == 5000.0);
	}
}
