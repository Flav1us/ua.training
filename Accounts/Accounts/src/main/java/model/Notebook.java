package model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	private List<Account> accounts = new ArrayList<>();
	
	public void addAccount(Account acc) {
		accounts.add(acc);
	}
}
