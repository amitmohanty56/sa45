package dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DAOConnection;
import dao.LecturerDAO;
import exception.DAOException;
import javabeans.EnrollmentDetails;
import javabeans.PerformanceDetails;
import model.User;
import model.CourseDTO;
import model.LecturerDTO;

public class LecturerDAOImpl implements LecturerDAO{
	
	private Connection conn = null;
	
	
	@Override
	public ArrayList<LecturerDTO> getAllLecturers() throws DAOException {
		conn = DAOConnection.openConnection();
		ArrayList<LecturerDTO> lecturers=new ArrayList<LecturerDTO>();
		try
		{
			Statement statement=conn.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from caps.lecturer");
			while(resultSet.next()){
				LecturerDTO lecturer=new LecturerDTO();
				lecturer.setUserID(resultSet.getInt(MySQLConstants.CAPS_LECTURER_COL_USERID));
				lecturer.setLecturerID(resultSet.getInt(MySQLConstants.CAPS_LECTURER_COL_LECTURERID));
				lecturer.setFirstName(resultSet.getString(MySQLConstants.CAPS_LECTURER_COL_FNAME));
				lecturer.setLastName(resultSet.getString(MySQLConstants.CAPS_LECTURER_COL_LNAME));
				lecturer.setEmail(resultSet.getString(MySQLConstants.CAPS_LECTURER_COL_EMAIL));
				lecturer.setPhoneNumber(resultSet.getInt(MySQLConstants.CAPS_LECTURER_COL_PH));
				lecturer.setAddress(resultSet.getString(MySQLConstants.CAPS_LECTURER_COL_ADDRESS));
				lecturer.setDescription(resultSet.getString(MySQLConstants.CAPS_LECTURER_COL_DESC));
				lecturers.add(lecturer);
				
			}
			resultSet.close();
			statement.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return lecturers;
	}
	
	@Override
	public LecturerDTO getLecturerByID(int lecturerID) throws DAOException{
		
		conn = DAOConnection.openConnection();
		LecturerDTO lecturer = new LecturerDTO();
		try {
			String query1 = "select * from user,lecturer where user.userID=lecturer.userID and lecturer.lecturerID=?;";
			PreparedStatement preparedStatement1 = conn.prepareStatement( query1 );
			preparedStatement1.setInt(1,lecturerID);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while( resultSet1.next() ) {
				lecturer.setLecturerID(resultSet1.getInt(MySQLConstants.CAPS_LECTURER_COL_LECTURERID));
				lecturer.setFirstName(resultSet1.getString(MySQLConstants.CAPS_LECTURER_COL_FNAME));
				lecturer.setLastName( resultSet1.getString(MySQLConstants.CAPS_LECTURER_COL_LNAME) );
				lecturer.setEmail( resultSet1.getString(MySQLConstants.CAPS_LECTURER_COL_EMAIL ) );
				lecturer.setPhoneNumber(resultSet1.getInt(MySQLConstants.CAPS_LECTURER_COL_PH));
				lecturer.setAddress(resultSet1.getString(MySQLConstants.CAPS_LECTURER_COL_ADDRESS));
				lecturer.setDescription(resultSet1.getString(MySQLConstants.CAPS_LECTURER_COL_DESC));


				lecturer.setUserName(resultSet1.getString(MySQLConstants.CAPS_USER_COL_USERNAME));
				lecturer.setPassword(resultSet1.getString(MySQLConstants.CAPS_USER_COL_PASSWORD));
				lecturer.setUserID(resultSet1.getInt(MySQLConstants.CAPS_USER_COL_USERID));
			}
			resultSet1.close();
			preparedStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lecturer;
	}
	
	
	@Override
	public ArrayList<CourseDTO> getAllCoursesByLecturer(int lecturerID) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<CourseDTO> coursesList = null;
		try {

			conn = DAOConnection.openConnection();
			coursesList = new ArrayList<CourseDTO>();
			String sql = "SELECT * FROM course c join lecturer lec on c.lecturerID = lec.lecturerID WHERE lec.userID = ? ORDER BY c.courseID";
			PreparedStatement sqlCommand = conn.prepareStatement(sql);
			sqlCommand.setInt(1, lecturerID);

			ResultSet rs = sqlCommand.executeQuery();
			while (rs.next()) {
				CourseDTO course = new CourseDTO(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_LECTURERID),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_CREDIT));
				coursesList.add(course);
			}
			DAOConnection.closeConnection();
		} catch (SQLException ex) {
			throw new DAOException("Error in GetAllCoursesBylecturer, Message:" + ex.getMessage());
		}
		return coursesList;
	}

	@Override
	public CourseDTO getCourseDetailsByCourseID(int courseID) throws DAOException {
		// TODO Auto-generated method stub
		CourseDTO course = null;
		try {
			conn = DAOConnection.openConnection();
			String sql = "SELECT * FROM course WHERE courseID = ? order by courseID";
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, courseID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				course = new CourseDTO(rs.getInt(MySQLConstants.CAPS_COURSE_COL_CourseID),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_CLASSSIZE),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_ENDDATE),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_LECTURERID),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_ENROLLSIZE),
						rs.getInt(MySQLConstants.CAPS_COURSE_COL_CREDIT));
			}
			DAOConnection.closeConnection();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new DAOException("Error in LecturerDAO:GetAllCoursesBylecturer, Message:" + ex.getMessage());
		}
		return course;
	}

	@Override
	public ArrayList<EnrollmentDetails> getStudentsEnrolledByCourseID(int courseID) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<EnrollmentDetails> studentList = null;
		try {

			conn = DAOConnection.openConnection();
			studentList = new ArrayList<EnrollmentDetails>();
			String sql = "SELECT stu.studentID,stu.firstName,stu.lastName,stu.email,stu.phoneNumber,enr.grade,enr.credit FROM enrollment enr, student stu where enr.studentID = stu.studentID  and enr.courseID = ? order by stu.studentID";
			PreparedStatement sqlCommand = conn.prepareStatement(sql);
			sqlCommand.setInt(1, courseID);
			//sqlCommand.setString(2, "Confirmed");
			ResultSet rs = sqlCommand.executeQuery();
			while (rs.next()) {
				EnrollmentDetails student = new EnrollmentDetails(rs.getInt(MySQLConstants.CAPS_STUDENT_COL_StudentID),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_firstName),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_lastName),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_email),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_phoneNumber),
						rs.getString(MySQLConstants.CAPS_ENROLLMENT_COL_grade),
						rs.getInt(MySQLConstants.CAPS_ENROLLMENT_COL_credit));
				studentList.add(student);
			}
			DAOConnection.closeConnection();
		} catch (SQLException ex) {
			throw new DAOException("Error in LecturerDAO:GetAllCoursesBylecturer, Message:" + ex.getMessage());
		}
		return studentList;
	}

	@Override
	public boolean gradeEnrollment(int studentID, int courseID, String grade, int credit) throws DAOException {
		boolean result = false;
		try {
			conn = DAOConnection.openConnection();
			String sql = "update enrollment set grade = ?, credit = ? where studentID = ? and courseID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, grade);
			stmt.setInt(2, credit);
			stmt.setInt(3, studentID);
			stmt.setInt(4, courseID);
			if (stmt.executeUpdate() > 0)
				result = true;
			DAOConnection.closeConnection();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new DAOException("Error in LecturerDAO:GetAllCoursesBylecturer, Message:" + ex.getMessage());
		}
		return result;
	}

	@Override
	public ArrayList<PerformanceDetails> getEnrollmentsByStudentID(int studentID, String name) throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<PerformanceDetails> enrollmentList = new ArrayList<PerformanceDetails>();
		try {
			conn = DAOConnection.openConnection();
			String sqlCommand = "select stu.studentID, stu.firstName, stu.lastName, c.courseCode, c.courseName, c.startDate,c.endDate, enr.grade, enr.credit from enrollment enr join student stu on enr.studentID = stu.studentID join course c on c.courseID = enr.courseID WHERE enr.studentID = ? OR stu.firstName like ? OR stu.lastName like ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCommand);
			stmt.setInt(1, studentID);
			stmt.setString(2, name);
			stmt.setString(3, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PerformanceDetails Enr = new PerformanceDetails(rs.getInt(MySQLConstants.CAPS_STUDENT_COL_StudentID),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_firstName),
						rs.getString(MySQLConstants.CAPS_STUDENT_COL_lastName),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSECODE),
						rs.getString(MySQLConstants.CAPS_COURSE_COL_COURSENAME),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE),
						rs.getDate(MySQLConstants.CAPS_COURSE_COL_STARTDATE),
						rs.getString(MySQLConstants.CAPS_ENROLLMENT_COL_grade),
						rs.getInt(MySQLConstants.CAPS_ENROLLMENT_COL_credit));
				enrollmentList.add(Enr);
			}
			DAOConnection.closeConnection();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new DAOException("Error in LecturerDAO:getEnrollmentsByStudentID, Message:" + ex.getMessage());
		}
		return enrollmentList;
	}

}
