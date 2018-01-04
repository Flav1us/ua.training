package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.DatabaseConnector;
import entities.Client;

public class MySQLDatabaseConnector implements DatabaseConnector {

	public Client getClient(int id) {
		DataSource ds = ConnectionPool.getDataSource();
		Connection c = null;
		Client cl = new Client();
		try {
			c = ds.getConnection();
			ResultSet rs =  c.createStatement().executeQuery("select * from client where idclient = '" + id + "'");
			rs.next(); //moves on first row
			cl.setPhone_number(rs.getString(4));
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return cl;
	}

}
