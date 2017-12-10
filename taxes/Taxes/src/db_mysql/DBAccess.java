package db_mysql;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import entity.IncomeType;

public class DBAccess {

    public static Map<IncomeType, Double> getIncome(int ID){
    	String connProp = "jdbc:" + "mysql:" + "//localhost/" + "training.proj1.taxes";
    	Map<IncomeType, Double> result = new HashMap<>();

    	loadDriver();
    	
    	try (Connection con = DriverManager.getConnection(connProp,"root" ,"root")) {
    		Statement query = con.createStatement();
    		ResultSet rs = query.executeQuery("SELECT type, amount FROM income where personID = " + ID + ";");
    		while(rs.next()){
    			result.put(IncomeType.getByName(rs.getString("type")),
    					   Double.parseDouble(rs.getString("amount")));
    		}
    		rs.close();
    	}
    	catch (SQLException e) {
    		//cant fix this inside the program
    		throw new RuntimeException(e.getMessage());
    	}
    	
    	return result;
    }

	private static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
    
}
