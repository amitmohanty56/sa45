package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAOConnection;
import dao.EnrollDAO;
import exception.DAOException;

import java.sql.PreparedStatement;

public class EnrollDAOImpl implements EnrollDAO {

	protected Connection conn;

	public boolean hasStudentEnrolled(int studentID, int courseID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		ResultSet rs = null;
		PreparedStatement preparedStatement;
		boolean result = false;
		try {
			preparedStatement = conn
					.prepareStatement("select * from caps.enrollment where studentID=? and courseID=?;");
			preparedStatement.setInt(1, studentID);
			preparedStatement.setInt(2, courseID);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return result;
	}

	public int findStudentIDByUserID(int userID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		int studentID=0;
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("select studentID from caps.student where userID=?");
			preparedStatement.setInt(1, userID);
			rs=preparedStatement.executeQuery();
			rs.next();
			studentID=rs.getInt(MySQLConstants.CAPS_STUDENT_COL_StudentID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return studentID;
	}

	public int insertEnrollment(int studentID, int courseID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		int result = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO caps.enrollment (courseID, studentID, credit) VALUES (?, ?, 0);");
			preparedStatement.setInt(1, courseID);
			preparedStatement.setInt(2, studentID);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return result;
	}
}