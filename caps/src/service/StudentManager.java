package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.StudentDAO;
import dao.mysql.MySQLConstants;
import model.StudentDTO;
import model.User;


public class StudentManager {
	
	private DaoFactory daoFactory;
	private StudentDAO studentDao;
	
	public StudentManager(){
		daoFactory = new DaoFactory(MySQLConstants.DB_TYPE);
		studentDao = daoFactory.getStudentDao();
	}
	
	public ArrayList<StudentDTO> getStudentList(){
		ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
			try {
				studentList = studentDao.findAllStudents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return studentList;
	}
	
	public StudentDTO getStudent(int id){
		StudentDTO student = new StudentDTO();
		try {
			student = studentDao.findStudentOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public void addStudent(User user, StudentDTO student){
		try {
			studentDao.addStudentOne(user, student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteStudent(int id){
		try {
			studentDao.deleteStudent(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(StudentDTO student){
		try {
			studentDao.updateStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
