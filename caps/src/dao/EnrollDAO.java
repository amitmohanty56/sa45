package dao;

import java.sql.SQLException;

public interface EnrollDAO {

	/*
	 * (non-Javadoc)
	 * @see dao.mysql.EnrollDAOImpl.hasStudentEnrolled(int)
	 */
	public boolean hasStudentEnrolled(int studentID, int courseID) throws SQLException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.EnrollDAOImp.insertEnrollment(int)
	 */
	public int insertEnrollment(int studentID,int courseID) throws SQLException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.EnrollDAOImp.findStudentIDByUserID(int)
	 */
	public int findStudentIDByUserID(int userID) throws SQLException;

}