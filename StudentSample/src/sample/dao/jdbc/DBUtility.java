package sample.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		// Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa45demo?useSSL=false", "root", "password");
		return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); return null;
		}
	}

}
