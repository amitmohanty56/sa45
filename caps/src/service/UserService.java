package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.UserDAO;
import exception.DAOException;
import exception.NotFoundException;
import model.User;

public class UserService {
	private UserDAO udao;
	private Connection conn;

	public UserService() throws NotFoundException {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caps", "root", "password");
			this.udao = DaoFactory.getUserDao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new NotFoundException("Driver Fault");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("SQL Fault");
		}
	}
	
	@SuppressWarnings("finally")
	public User authenticate(User u) throws NotFoundException {
		
		User list = new User();
		try {
			list = this.udao.searchUserMatching(u);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return list;
		}

	}
	
	@SuppressWarnings("finally")
	public boolean checkLoginUser(User u) {
		boolean b = false;

		try {
			b = this.udao.checkLoginUser(u);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return b;
		}
	}
	
}
