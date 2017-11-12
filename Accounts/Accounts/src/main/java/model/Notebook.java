package model;

import java.util.ArrayList;
import java.util.List;

import controller.LoginExistsException;

public class Notebook {
	private List<Account> accounts = new ArrayList<>();
	
	public void addAccount(Account new_acc) throws LoginExistsException {
		for(Account acc : accounts) {
			if(acc.getNickName().equals(new_acc.getNickName())) {
				throw new LoginExistsException(new_acc.getFirstName(), new_acc.getLastName());
			}
		}
		accounts.add(new_acc);
	}
}
