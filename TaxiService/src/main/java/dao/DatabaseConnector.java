package dao;

import entity.Client;

public interface DatabaseConnector {
	public Client getClient(String login, String password) throws ClientNotExistsException;

	public void addClient(Client new_client, String password);
}
