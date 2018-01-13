package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.impl.MySQLDatabaseConnector;
import entity.Client;
import util.Hash;

public class ClientDAO extends MySQLDatabaseConnector {
	
	//public Client getClient(String login, String password) throws ClientNotExistsException {
	//	ResultSet rs = getClientFromDB(login, password);
	//	return tryExtractClient(rs);
	//}

	
	public Client getClientFromDB(String login, String password) throws ClientNotExistsException {
		try (Connection c = ds.getConnection()) {
			ResultSet rs =  c.createStatement().executeQuery
					("select * from client where login = '" + login +
					"' and password_hash = '" + Hash.sha256(password) + "'");
			return tryExtractClient(rs);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}
	
	public void addNewClient(Client new_client, String password) throws AlreadyExistsException {
		try (Connection c = ds.getConnection()) {
			String query = String.format(
					"insert into mydb.client (login, password_hash, phone) values ('%s', '%s', '%s');",
					new_client.getLogin(), Hash.sha256(password), new_client.getPhoneNumber());
			//System.out.println(query);
			c.createStatement().executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new AlreadyExistsException();
		}	
	}

	private Client tryExtractClient(ResultSet rs) throws ClientNotExistsException {
		Client cl = null;
		try {	
			rs.next(); //moves on first row
			cl = new Client.Builder()
					.setLogin(rs.getString(2))
					.setPhoneNumber(rs.getString(4))
					.setDiscount(Integer.parseInt(rs.getString(5)))
					.build();
		}
		catch (SQLException e) {
			throw new ClientNotExistsException();
		}
		return cl;
	}

}
