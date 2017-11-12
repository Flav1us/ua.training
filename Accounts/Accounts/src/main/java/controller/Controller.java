package controller;

import java.util.Scanner;

import model.Account;
import model.Model;
import model.Notebook;
import view.View;

public class Controller {
	@SuppressWarnings("unused")
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
		ConsoleReader cr = new ConsoleReader(view);
		do {
			tryAddAccount(notebook, cr);
		} while(wantAddAnotherAcc());
	}

	private void tryAddAccount(Notebook notebook, ConsoleReader cr) {
		try {
			notebook.addAccount(cr.getAccount());
		}
		catch (LoginExistsException exists) {
			addWithAnotherLogin(notebook, cr, exists);
		}
	}

	private void addWithAnotherLogin(Notebook notebook, ConsoleReader cr, LoginExistsException exists) {
		while(true) {
			view.printStored("login_exists");
			String new_login = cr.getFromConsole(AccountParameter.NICK_NAME);
			try {
				notebook.addAccount(new Account(exists.first_name, exists.last_name, new_login));
				break;
			}
			catch(LoginExistsException e) {
				continue;
			}
		}
	}
	
	private boolean wantAddAnotherAcc() {
		view.printStored("want_another_acc?Y/N");
		String response = sc.nextLine();
		return response.equals("Y");
	}

}
