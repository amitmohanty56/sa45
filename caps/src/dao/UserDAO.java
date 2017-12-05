package dao;


import exception.DAOException;
import model.User;

public interface UserDAO {
	
	public  User searchUserMatching(User valueObject) throws DAOException;
	public boolean checkLoginUser(User valueObject) throws DAOException;
	
}
