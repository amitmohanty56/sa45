package dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.DAOConnection;
import exception.DAOException;
import model.CourseDTO;
import model.EnrolledCourseDTO;


public class CourseDAOImpl implements CourseDAO{
	
	protected Connection conn;
	
	public ArrayList<CourseDTO> findAllCourses() throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		ArrayList<CourseDTO> courses = new ArrayList<CourseDTO>();

		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM caps.course INNER JOIN caps.lecturer ON caps.course.lecturerID = caps.lecturer.lecturerID;";
		 
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			CourseDTO course = new CourseDTO();
			course.setCourseId(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID));
			course.setCourseCode(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE));
			course.setCourseName(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME));
			course.setStartDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE));
			course.setEndDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE));
			course.setClassSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE));
			course.setEnrolledSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE));
			course.setFirstName(rs.getString(MySQLConstants.CAPS_LECTURER_COL_FNAME));
			course.setLastName(rs.getString(MySQLConstants.CAPS_LECTURER_COL_LNAME));
			course.setLecturerID(rs.getInt(MySQLConstants.CAPS_LECTURER_COL_LECTURERID));
			course.setCredit(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CREDIT));
			courses.add(course);
			
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return courses;
	}
	
	@Override
	public ArrayList<EnrolledCourseDTO> findCourseByStudentId(int loginStudentId) throws DAOException {
		ArrayList<EnrolledCourseDTO> enrolledCourses = new ArrayList<EnrolledCourseDTO>();
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		
		try {
			String q = "SELECT c.courseCode,c.courseName,c.startDate, c.endDate,e.grade,e.credit FROM caps.enrollment e, caps.course c, caps.student s "
					+ "WHERE s.userID =? "
					+ "AND s.studentID = e.studentID "
					+ "AND e.courseID = c.courseID";
			
			PreparedStatement preparedStatement = conn.prepareStatement(q);
			preparedStatement.setInt(1, loginStudentId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				EnrolledCourseDTO course = new EnrolledCourseDTO();
				course.setCourseCode(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE));
				course.setCourseName(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME));
				course.setGrade(rs.getString(MySQLConstants.CAPS_ENROLLMENT_COL_grade));
				course.setCredit(rs.getString(MySQLConstants.CAPS_ENROLLMENT_COL_credit));
				course.setStartDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE));
				course.setEndDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE));
				enrolledCourses.add(course);
			}
			rs.close();
			preparedStatement.close();
			
		} catch (Exception e) {
			String error = "Error getting enrolled courses. Nested Exception is: " +e;
			throw new DAOException(error);
		}finally{
			try{
				conn.rollback();
				conn.close();
			}catch(Exception e){
				
			}
		}
		
		return enrolledCourses;
	}
	
	public CourseDTO findCourseByCode(String courseCode) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		CourseDTO course = new CourseDTO();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("SELECT * FROM caps.course where courseCode = ?");
			preparedStatement.setString(1, courseCode);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				course.setCourseId(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID));
				course.setCourseCode(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE));
				course.setCourseName(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME));
				course.setStartDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE));
				course.setEndDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE));
				course.setClassSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE));
				course.setEnrolledSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE));
				course.setLecturerID(rs.getInt(MySQLConstants.CAPS_COURSE_COL_LECTURERID));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return course;

	}

	public CourseDTO findCourseByID(int courseID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		CourseDTO course = new CourseDTO();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM caps.course where courseID = ?");
			preparedStatement.setInt(1, courseID);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				course.setCourseId(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID));
				course.setCourseCode(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE));
				course.setCourseName(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME));
				course.setStartDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE));
				course.setEndDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE));
				course.setClassSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE));
				course.setEnrolledSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE));
				course.setLecturerID(rs.getInt(MySQLConstants.CAPS_COURSE_COL_LECTURERID));
				course.setCredit(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CREDIT));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return course;

	}

	public int updateCourseEnrolledSize(CourseDTO course) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		int result = 0;
		PreparedStatement preparedStatement = conn
				.prepareStatement("UPDATE caps.course SET enrollSize=? WHERE courseID=?");
		preparedStatement.setInt(1, course.getEnrolledSize());
		preparedStatement.setInt(2, course.getCourseId());
		result = preparedStatement.executeUpdate();
		conn.close();
		return result;
	}
	
	public ArrayList<CourseDTO> findAllCoursesNotEnrolled(int studentID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		ArrayList<CourseDTO> courses = new ArrayList<CourseDTO>();

		Statement stmt = conn.createStatement();
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT * FROM caps.enrollment where courseID=? and studentID=?;");

		String query = "SELECT * FROM caps.course INNER JOIN caps.lecturer ON caps.course.lecturerID = caps.lecturer.lecturerID ;";

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			CourseDTO course = new CourseDTO();
			course.setCourseId(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID));
			course.setCourseCode(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE));
			course.setCourseName(rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME));
			course.setStartDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE));
			course.setEndDate(rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE));
			course.setClassSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE));
			course.setEnrolledSize(rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE));
			course.setFirstName(rs.getString(MySQLConstants.CAPS_LECTURER_COL_FNAME));
			course.setLastName(rs.getString(MySQLConstants.CAPS_LECTURER_COL_LNAME));
			course.setLecturerID(rs.getInt(MySQLConstants.CAPS_LECTURER_COL_LECTURERID));

			preparedStatement.setInt(1, rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID));
			preparedStatement.setInt(2, studentID);
			ResultSet rs2 = preparedStatement.executeQuery();
			if (rs2.next()) {
				course.setIsEnrolled(1);
			} else {
				course.setIsEnrolled(0);
			}

			courses.add(course);
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return courses;
	}
	
	//CRUD
	@Override
	public void insertCourse(CourseDTO course) throws DAOException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		try{
			java.util.Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(course.getStartdate());
			java.util.Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(course.getEnddate());
			Date sqlstartdate = new Date(startdate.getTime());
			Date sqlenddate = new Date(enddate.getTime());
			
			String insertQuery = "INSERT into course (courseCode, courseName, lecturerID, startDate, endDate, classSize, enrollSize, credit) values(?,?,?,?,?,?,?,?)";
	        
			PreparedStatement ps = conn.prepareStatement( insertQuery );
			ps.setString(1, course.getCourseCode());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getLecturerID());
			ps.setDate(4, sqlstartdate);
			ps.setDate(5, sqlenddate);
			ps.setInt(6, course.getClassSize());
			ps.setInt(7,0);
			ps.setInt(8, course.getCredit());
			ps.executeUpdate();
			ps.close();
			
		}catch(Exception e){
			String error = "Error creating course. Nested Exception is: " + e;
			throw new DAOException(error);
		}finally{
			try{
				conn.rollback();
				conn.close();
			}catch(Exception e){
			}
		}
	}

	@Override
	public void updateCourse(CourseDTO course) throws DAOException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		try{
			java.util.Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(course.getStartdate());
			java.util.Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(course.getEnddate());
			Date sqlstartdate = new Date(startdate.getTime());
			Date sqlenddate = new Date(enddate.getTime());
			
			String updateQuery = "UPDATE course set courseCode=?, courseName=?, lecturerID=?, startDate=?, endDate=?, classSize=?, enrollSize=?, credit=?  where courseId=?";
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			ps.setString(1, course.getCourseCode());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getLecturerID());
			ps.setDate(4, sqlstartdate);
			ps.setDate(5, sqlenddate);
			ps.setInt(6, course.getClassSize());
			ps.setInt(7, 0);
			ps.setInt(8, course.getCredit());
			ps.setInt(9, course.getCourseId());
			ps.executeUpdate();
			ps.close();
			
		}catch(Exception e){
			String error = "Error updating course. Nested Exception is: " +e;
			throw new DAOException(error);
		}finally{
			try{
				conn.rollback();
				conn.close();
			}catch(Exception e){
				
			}
		}
		
	}
	
	@Override
	public void deleteCourse(int courseId) throws DAOException{
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		try{
			String deletequery = "DELETE FROM caps.course WHERE courseID=?";
			PreparedStatement ps = conn.prepareStatement(deletequery);
			ps.setInt(1, courseId);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			String error="Error deleting coure. Nested Exception is: " + e;
			new DAOException(error);
		}
		
	}
	
}