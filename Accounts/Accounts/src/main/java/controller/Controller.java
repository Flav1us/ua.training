package controller;

import java.time.temporal.IsoFields;
import java.util.Scanner;

import model.Account;
import model.Model;
import model.Notebook;
import view.View;

public class Controller {
	private Model model;
	private View view;
	
	Scanner sc = new Scanner(System.in);
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		Notebook notebook = new Notebook();
		view.printStored("intro");
		do {
			notebook.addAccount(getAccount());
		} while(wantAddAnotherAcc());
	}
	
	private boolean wantAddAnotherAcc() {
		view.printStored("want_another_acc?Y/N");
		String response = sc.nextLine();
		return response.equals("Y");
	}

	public Account getAccount() {
		String first_name = getFirstName();
		String last_name = getLastName();
		String nick_name = getNickName();
		return new Account(first_name, last_name, nick_name);
	}
	
	public String getFirstName() {
		view.printStored("account.need_first_name");
		String first_name;
		do {
			first_name = sc.nextLine();
			if(Validator.isFirstNameValid(first_name)) {
				return first_name;
			}
			else {
				view.printStored("account.invalid_first_name");
			}
		} while (true);
	}
	
	public String getLastName() {
		view.printStored("account.need_last_name");
		String last_name;
		do {
			last_name = sc.nextLine();
			if(Validator.isLastNameValid(last_name)) {
				return last_name;
			}
			else {
				view.printStored("account.invalid_last_name");
			}
		} while (true);
	}
	
	public String getNickName() {
		view.printStored("account.need_nick_name");
		String nick_name;
		do {
			nick_name = sc.nextLine();
			if(Validator.isNickNameValid(nick_name)) {
				return nick_name;
			}
			else {
				view.printStored("account.invalid_nick_name");
			}
		} while (true);
	}
}
