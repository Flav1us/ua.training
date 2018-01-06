package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.ClientNotExistsException;
import dao.DatabaseConnector;
import entities.Client;
import util.Hash;

public class MySQLDatabaseConnector implements DatabaseConnector {

	public Client getClient(String login, String password) throws ClientNotExistsException {
		DataSource ds = ConnectionPool.getDataSource();
		ResultSet rs = tryGetClientFromDB(login, password, ds);
		Client cl = extractClient(rs);
		return cl;
	}
	
	private ResultSet tryGetClientFromDB(String login, String password, DataSource ds) {
		ResultSet rs = null;
		try {
			Connection c = ds.getConnection();
			rs =  c.createStatement().executeQuery
					("select * from client where login = '" + login +
					"' and password_hash = '" + Hash.sha256(password) + "'");
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return rs;
	}

	private Client extractClient(ResultSet rs) throws ClientNotExistsException {
		Client cl = new Client();
		try {	
			rs.next(); //moves on first row
			cl.setPhone_number(rs.getString(4));
		}
		catch (SQLException e) {
			throw new ClientNotExistsException();
		}
		return cl;
	}

}