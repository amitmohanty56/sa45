package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.DaoFactory;
import dao.mysql.MySQLConstants;
import exception.DAOException;
import model.CourseDTO;
import model.EnrolledCourseDTO;

public class CourseManager {
	
	private DaoFactory daoFactory;
	private CourseDAO courseDAO;
	
	public CourseManager(){
		daoFactory = new DaoFactory(MySQLConstants.DB_TYPE);
		courseDAO = daoFactory.getCourseDao();
	}
	
	public ArrayList<CourseDTO> getCourseList(){
		ArrayList<CourseDTO> courses = new ArrayList<CourseDTO>();
		try{
			courses = courseDAO.findAllCourses();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return courses;
	}
	
	public void insertCourse(CourseDTO course){
		try{
			courseDAO.insertCourse(course);
		}catch (DAOException e){
			e.printStackTrace();
		}
	}
	
	public void updateCourse(CourseDTO course){
		try{
			courseDAO.updateCourse(course);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(int courseId){
		try{
			courseDAO.deleteCourse(courseId);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<EnrolledCourseDTO> findCourseByStudentId(int loginStudentId) {
		ArrayList<EnrolledCourseDTO> enrolledCourses = new ArrayList<EnrolledCourseDTO>();
		try{
			enrolledCourses = courseDAO.findCourseByStudentId(loginStudentId);
		}catch(DAOException e){
			e.printStackTrace();
		}finally{
			return enrolledCourses;
		}
	}
	
	public CourseDTO findCourseByCode(String courseCode) {
		CourseDTO course = new CourseDTO();
		try {
			course = courseDAO.findCourseByCode(courseCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	
	public CourseDTO findCourseByID(int courseID) {
		CourseDTO course = new CourseDTO();
		try {
			course = courseDAO.findCourseByID(courseID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	
	public int updateCourseEnrolledSize(CourseDTO course) throws SQLException {
		return courseDAO.updateCourseEnrolledSize(course);
	}
	
	public ArrayList<CourseDTO> getCourseListNotEnrolled(int studentID){
		ArrayList<CourseDTO> courses = new ArrayList<CourseDTO>();
		try{
			courses = courseDAO.findAllCoursesNotEnrolled(studentID);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return courses;
	}
	
}
