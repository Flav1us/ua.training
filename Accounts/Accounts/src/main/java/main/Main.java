package main;

import java.util.regex.Pattern;

import controller.Controller;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(m, v);
		c.processUser();
		//System.out.println(Pattern.matches("[a-zA-Zа-яА-ЯіїєІЇЄ']+(([a-zA-Zа-яА-ЯіїєІЇЄ' ])?[a-zA-Zа-яА-ЯіїєІЇЄ']*)*", "АнТон"));
		
	}

}
