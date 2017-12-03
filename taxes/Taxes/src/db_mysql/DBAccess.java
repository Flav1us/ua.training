package db_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBAccess {

    public static Map<IncomeType, Double> getIncome(int ID){
    	String connProp = "jdbc:" + "mysql:" + "//localhost/" + "training.proj1.taxes";
    	Map<IncomeType, Double> res = new HashMap<>();

    	loadDriver();
    	
    	try (Connection con = DriverManager.getConnection(connProp,"root" ,"root")) {
    		Statement query = con.createStatement();
    		ResultSet rs = query.executeQuery("SELECT type, amount FROM income where personID = " + ID + ";");
    		while(rs.next()){
    			res.put(IncomeType.getByName(rs.getString("type")),
    					Double.parseDouble(rs.getString("amount")));
    		}
    		rs.close();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return res;
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
