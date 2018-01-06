package dao;

import entities.Client;

public interface DatabaseConnector {
	public Client getClient(String login, String password) throws ClientNotExistsException;
}
