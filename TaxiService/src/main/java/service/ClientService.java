package service;

import dao.AlreadyExistsException;
import dao.ClientDAO;
import dao.ClientNotExistsException;
import entity.Client;

public class ClientService {
	
	ClientDAO client_dao = new ClientDAO();

	public Client getClient(String login, String password) throws ClientNotExistsException {	
		return client_dao.getClientFromDB(login, password);
	}

	public void registerClient(Client new_client, String password) throws AlreadyExistsException {
		client_dao.addNewClient(new_client, password);
	}
	
	/*public Client getClient(String login, String password) throws ClientNotExistsException {	
		DAOFactory daofactory = DAOFactory.getInstance();
		ClientDAO client_dao = daofactory.createClientDAO();
		return client_dao.getClientFromDB(login, password);
	}*/
}
