package dao;

import java.util.ArrayList;

import exception.DAOException;
import javabeans.EnrollmentDetails;
import javabeans.PerformanceDetails;
import model.CourseDTO;
import model.LecturerDTO;

public interface LecturerDAO {
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.getAllLecturers()
	 */
	public ArrayList<LecturerDTO> getAllLecturers() throws DAOException;
	
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.getAllLecturers()
	 */public LecturerDTO getLecturerByID( int lecturerId ) throws DAOException;
	
	 /*
		 * (non-Javadoc)
		 * @see dao.mysql.LecturerDAOImpl.getAllCoursesByLecturer()
		 */
	public ArrayList<CourseDTO> getAllCoursesByLecturer(int lecturerID) throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.getCourseDetailsByCourseID(int)
	 */
	public CourseDTO getCourseDetailsByCourseID(int courseID) throws DAOException;

	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.getStudentsEnrolledByCourseID(int)
	 */
	public ArrayList<EnrollmentDetails> getStudentsEnrolledByCourseID(int courseID) throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.gradeEnrollment(int,int,java.lang.String,int)
	 */
	public boolean gradeEnrollment(int studentID, int enrollmentID, String grade, int credit) throws DAOException;

	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerDAOImpl.getEnrollmentsByStudentID(int,java.lang.String)
	 */
	public ArrayList<PerformanceDetails> getEnrollmentsByStudentID(int studentID, String name) throws DAOException;
	
}
