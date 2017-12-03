import static org.junit.Assert.*;

import org.junit.Test;

import db_mysql.IncomeType;

public class TestIncomeTypeGetByName {
	@Test
	public void test() {
		assertTrue(IncomeType.primary_job.equals(IncomeType.getByName("primary_job")));
	}
}
