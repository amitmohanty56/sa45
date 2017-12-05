package service;

import java.sql.SQLException;

import dao.DaoFactory;
import dao.EnrollDAO;
import dao.mysql.MySQLConstants;

public class EnrollManager {

	private DaoFactory daoFactory;
	private EnrollDAO enrollDAO;
	
	public EnrollManager() {
		daoFactory = new DaoFactory(MySQLConstants.DB_TYPE);
		enrollDAO = daoFactory.getEnrollDao();
	}
	
	public boolean hasStudentEnrolled(int studentID,int courseID) throws SQLException {
		return enrollDAO.hasStudentEnrolled(studentID, courseID);
	}
	
	public int insertEnrollment(int studentID,int courseID) throws SQLException {
		return enrollDAO.insertEnrollment(studentID, courseID);
	}
	public int findStudentIDByUserID(int userID) throws SQLException {
		return enrollDAO.findStudentIDByUserID(userID);
	}
}
