package dao;

import dao.mysql.CourseDAOImpl;
import dao.mysql.EnrollDAOImpl;
import dao.mysql.LecturerDAOImpl;
import dao.mysql.LecturerSetupDAOImpl;
import dao.mysql.MySQLConstants;
import dao.mysql.StudentDAOImpl;
import dao.mysql.UserDAOImpl;

public class DaoFactory {
	
	private static String dbType;
	
	
	public DaoFactory(String dbType){
		DaoFactory.dbType = dbType;
	}
	
	public static StudentDAO getStudentDao() {
		StudentDAO sdao = null;
		switch (dbType) {
		case MySQLConstants.DB_TYPE:
			sdao = new StudentDAOImpl();
			break;
		}
		return sdao;
	}

	public static LecturerDAO getLecturerDao() {
		LecturerDAO ldao = null;
		switch (dbType) {
		case MySQLConstants.DB_TYPE:
			ldao = new LecturerDAOImpl();
			break;
		}
		return ldao;
	}

	public static CourseDAO getCourseDao() {
		CourseDAO cdao = null;
		switch (dbType) {
		case MySQLConstants.DB_TYPE:
			cdao = new CourseDAOImpl();
			break;
		}
		return cdao;
	}
	
	public static UserDAO getUserDao(){
		UserDAO udao = new UserDAOImpl();
		return udao;
	}
	
	public static EnrollDAO getEnrollDao(){
		EnrollDAO edao = new EnrollDAOImpl();
		return edao;
	}
	
	
	public static LecturerSetupDAO getLecturerSetupDao(){
		LecturerSetupDAO lecSetupdao = new LecturerSetupDAOImpl();
		return lecSetupdao;
				
	}
	
}
