package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOConnection;
import dao.UserDAO;
import exception.DAOException;
import exception.NotFoundException;
import model.User;

public class UserDAOImpl implements UserDAO {
	
	private User createValueObject() {
		// TODO Auto-generated method stub
		return new User();
	}

	Connection conn;
	@Override
	public User searchUserMatching(User valueObject) throws DAOException{
		conn = DAOConnection.openConnection();
		User temp = new User();
		String sql = "SELECT * FROM USER WHERE userName='" + valueObject.getName() + "' AND password='" + valueObject.getPassword() +"'";
		try{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				temp.setUserId(rs.getLong("userID"));
				temp.setName(rs.getString("userName"));
				temp.setPassword(rs.getString("password"));
				temp.setRole(rs.getString("role"));
			}
			statement.close();
		}
		catch(SQLException e){
			String error = "Cannot find matching user. Nested Exception is: " +e;
			throw new DAOException(error);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	@Override
	public boolean checkLoginUser(User valueObject) throws DAOException {
		boolean result = false;
		conn = DAOConnection.openConnection();
		User temp = new User();
		String sql = "SELECT * FROM USER WHERE userName='" + valueObject.getName() + "' AND password='" + valueObject.getPassword() +"'";
		try{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				result = true;
			}
			statement.close();
		}
		catch(SQLException e){
			String error = "Cannot find matching user. Nested Exception is: " +e;
			throw new DAOException(error);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
