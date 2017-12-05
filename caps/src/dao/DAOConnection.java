package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.mysql.MySQLConstants;
import exception.DAOException;

public class DAOConnection {

	private static Connection connection = null;

	public static Connection openConnection() throws DAOException {
		try {
			Class.forName(MySQLConstants.DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Error: Class not found exception!");
		}
		try {
			connection = DriverManager.getConnection(MySQLConstants.URL, MySQLConstants.USER, MySQLConstants.PASSWORD);
		} catch (SQLException e) {
			throw new DAOException("Error: Unable to Connect to Database!");
		}
		return connection;
	}

	public static void closeConnection() throws DAOException {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new DAOException("Error in closing connection!");
		}
	}
}
