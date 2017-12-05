package service;


import java.util.ArrayList;
import dao.DaoFactory;
import dao.LecturerDAO;
import dao.mysql.MySQLConstants;
import exception.DAOException;
import javabeans.CourseAndStudents;
import javabeans.EnrollmentDetails;
import javabeans.PerformanceDetails;
import model.CourseDTO;
import model.LecturerDTO;
import model.User;

public class LecturerManager {
	
	private DaoFactory objFac;
	private LecturerDAO lecturerDAO;
	private LecturerDTO lecturer;
	private User user;
	
	public LecturerManager(){
		objFac = new DaoFactory(MySQLConstants.DB_TYPE);
		lecturerDAO = objFac.getLecturerDao();
	}
	
	public ArrayList<LecturerDTO> getLecturerList(){
		ArrayList<LecturerDTO> lecturers=new ArrayList<LecturerDTO>();
			try {
				lecturers= lecturerDAO.getAllLecturers();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return lecturers;
	}
	
	public LecturerDTO getLecturerByID(int lecturerID){
		LecturerDTO lecturer = new LecturerDTO();
		try{
			lecturer = lecturerDAO.getLecturerByID(lecturerID);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return lecturer;
	}
	
	
	public ArrayList<CourseDTO> getAllCoursesByLecturer(int lecturerUserID) {
		// TODO Auto-generated method stub
		ArrayList<CourseDTO> coursesList = null;
		try {
			objFac = new DaoFactory(MySQLConstants.DB_TYPE);
			return objFac.getLecturerDao().getAllCoursesByLecturer(lecturerUserID);
		} catch (DAOException ex) {

		}
		return coursesList;
	}

	public CourseAndStudents getCourseAndStudentByCourseID(int courseID) {
		CourseDTO courseDetails = this.getCourseDetailsByCourseID(courseID);
		ArrayList<EnrollmentDetails> lstStudents = this.getStudentsEnrolledByCourseID(courseID);
		return new CourseAndStudents(courseDetails, lstStudents);
	}

	public CourseDTO getCourseDetailsByCourseID(int courseID) {
		// TODO Auto-generated method stub
		CourseDTO course = null;
		try {
			objFac = new DaoFactory(MySQLConstants.DB_TYPE);
			return objFac.getLecturerDao().getCourseDetailsByCourseID(courseID);
		} catch (DAOException ex) {
			// TODO Auto-generated catch block

		}
		return course;
	}

	public ArrayList<EnrollmentDetails> getStudentsEnrolledByCourseID(int courseID) {
		// TODO Auto-generated method stub
		ArrayList<EnrollmentDetails> studentList = null;
		try {
			objFac = new DaoFactory(MySQLConstants.DB_TYPE);
			return objFac.getLecturerDao().getStudentsEnrolledByCourseID(courseID);
		} catch (DAOException ex) {

		}
		return studentList;
	}

	public boolean gradeEnrollment(int studentID, int courseID, String grade) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			objFac = new DaoFactory(MySQLConstants.DB_TYPE);
			CourseDTO cObj = objFac.getLecturerDao().getCourseDetailsByCourseID(courseID);
			int credit = grade.compareTo("F");
			credit = credit < 0 ? cObj.getCredit() : 0;
			result = objFac.getLecturerDao().gradeEnrollment(studentID, courseID, grade, credit);
		} catch (DAOException ex) {
			// TODO Auto-generated catch block

		}
		return result;
	}

	public ArrayList<PerformanceDetails> getEnrollmentsByStudentID(int studentID, String name) {

		ArrayList<PerformanceDetails> enrollmentList = new ArrayList<PerformanceDetails>();
		try {
			objFac = new DaoFactory(MySQLConstants.DB_TYPE);
			return objFac.getLecturerDao().getEnrollmentsByStudentID(studentID, name);
		} catch (DAOException ex) {
			// TODO Auto-generated catch block
		}
		return enrollmentList;
	}

	
}
