package services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.DatabaseConnector;
import dao.impl.MySQLDatabaseConnector;
import entities.Client;

public class TestDB {
	@Test
	//1. creating basic entities
	public void Test() {
		int client_id = 6;
		DatabaseConnector dc = new MySQLDatabaseConnector();
		Client client = dc.getClient(client_id);
		assertFalse(client.equals(null));
		assertTrue(client.getPhoneNumber().equals("80965551144"));
	}
}
