package service;


import dao.DaoFactory;
import dao.LecturerSetupDAO;
import dao.mysql.MySQLConstants;
import exception.DAOException;
import model.LecturerDTO;
import model.User;

public class LecturerSetupManager {
	
	private DaoFactory daoFactory;
	private LecturerSetupDAO lecSetupDAO;
	
	public LecturerSetupManager(){
		daoFactory = new DaoFactory(MySQLConstants.DB_TYPE);
		lecSetupDAO = daoFactory.getLecturerSetupDao();
	}
	
	public void addLecturer(User user,LecturerDTO lecturer) {
		try{
			lecSetupDAO.addLecturer(user, lecturer);
		}catch (DAOException e){
			e.printStackTrace();
		}
	}
	
	public void updateLecturer(LecturerDTO lecturer,User user){
		try{
			lecSetupDAO.updateLecturer(lecturer,user);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteLecturer(int lecturerID){
		try{
			lecSetupDAO.deleteLecturer(lecturerID);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
}
