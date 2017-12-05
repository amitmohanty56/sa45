package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CourseDTO;
import model.EnrolledCourseDTO;
import exception.DAOException;

public interface CourseDAO {
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#findAllCourses()
	 */
	public ArrayList<CourseDTO> findAllCourses () throws SQLException; 
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#findCourseById(int)
	 */
	public ArrayList<EnrolledCourseDTO> findCourseByStudentId(int loginStudentId) throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#insertCourse(model.CourseDTO)
	 */
	public void insertCourse(CourseDTO course)throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#updateCourse(model.CourseDTO)
	 */
	public void updateCourse(CourseDTO course)throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#deleteCourse(model.CourseDTO)
	 */
	public void deleteCourse(int courseId) throws DAOException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#findCourseByCode(java.lang.String)
	 */
	public CourseDTO findCourseByCode(String courseCode) throws SQLException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#findCourseByID(int)
	 */
	public CourseDTO findCourseByID(int courseID) throws SQLException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#updateCourseEnrolledSize(model.CourseDTO)
	 */
	public int updateCourseEnrolledSize(CourseDTO course) throws SQLException;
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.CourseDAOImpl#updateCourseEnrolledSize(int)
	 */
	public ArrayList<CourseDTO> findAllCoursesNotEnrolled(int studentID) throws SQLException;
	
}
