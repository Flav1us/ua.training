package dao;

import entities.Client;

public interface DatabaseConnector {
	public Client getClient(int id);
}
