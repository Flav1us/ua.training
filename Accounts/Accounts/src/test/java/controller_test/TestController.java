package controller_test;

import org.junit.Assert;
import org.junit.Test;

import controller.Validator;

public class TestController {

	@Test
	public void testIsValidFirstName() {
		String[] first_names = {"Anton"/*, "Сергей", "Лёня", "Леонід", "Зигфрид"*/, "Paul"};
		for(String name : first_names) {
			Assert.assertTrue("wrong name", Validator.isFirstNameValid(name));
		}
	}

}
