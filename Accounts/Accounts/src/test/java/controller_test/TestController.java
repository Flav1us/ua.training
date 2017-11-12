package controller_test;

import org.junit.Assert;
import org.junit.Test;

import controller.AccountParameter;
import controller.ConsoleReader;

public class TestController {

	@Test
	public void testIsValidFirstName() {
		String[] first_names = {"Anton", "Сергей", "Лёня", "Леонід", "Зигфрид", "Paul"};
		for(String name : first_names) {
			Assert.assertTrue("wrong name " + name, ConsoleReader.isAccParamValid(AccountParameter.FIRST_NAME, name));
		}
	}

}
