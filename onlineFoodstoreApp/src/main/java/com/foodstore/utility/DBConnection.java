package com.foodstore.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	
	private static Connection con = null;
	public static Connection getDBConn() throws Exception {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\Prashant\\eclipse-workspace\\onlineFoodstoreApp\\db.properties"));
		
		Class.forName(prop.getProperty("driver"));
		
		
		con = DriverManager.getConnection(prop.getProperty("url"),prop);
		
		
		
		return con;
	}
	
	public static void closeCon() throws SQLException {
		if(con!=null) {
			con.close();
		}	
	}
	
}
