package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MySQLDatabaseConnector /*implements DatabaseConnector*/ {

	protected DataSource ds = ConnectionPool.getDataSource();

	
}