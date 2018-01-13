package services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.AlreadyExistsException;
import dao.ClientNotExistsException;
import entity.Client;
import service.ClientService;

public class TestDB {
	@Test
	//1. creating basic entities
	public void TestGetClient() throws ClientNotExistsException {
		ClientService cs = new ClientService();
		Client client = cs.getClient("flavius1", "password");
		assertFalse(client.equals(null));
		assertTrue(client.getPhoneNumber().equals("80965551144"));
	}
	
	@Test
	public void TestAddClient() throws AlreadyExistsException {
		ClientService cs = new ClientService();
		Client flav = new Client.Builder()
				.setLogin("flavius2")
				.setPhoneNumber("0966544455")
				.setDiscount(0)
				.build();
		cs.registerClient(flav, "password");
	}
}
