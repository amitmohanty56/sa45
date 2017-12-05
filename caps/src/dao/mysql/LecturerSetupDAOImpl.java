package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAOConnection;
import dao.LecturerSetupDAO;
import exception.DAOException;
import model.User;
import model.LecturerDTO;



public class LecturerSetupDAOImpl implements LecturerSetupDAO{
	
	protected Connection conn;
	LecturerDTO lecturer = new LecturerDTO();


	@Override
	public void addLecturer(User user,LecturerDTO lecturer) throws DAOException{
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		try{
			
			String insertQuery2 = "insert into user (userName, password,role) values (?,?,?)";
			PreparedStatement ps2 = conn.prepareStatement(insertQuery2);
			ps2.setString(1, lecturer.getUserName());
			ps2.setString(2, lecturer.getPassword());
			ps2.setString(3,"lecturer");
			ps2.executeUpdate();
			ps2.close();
			
			String insertQuery1= "INSERT INTO lecturer "
					+ "(userId, firstName, lastName, email, phoneNumber, address,description) " + "VALUES ("
					+ "LAST_INSERT_ID() ,'" + lecturer.getFirstName() + "','" + lecturer.getLastName() + "','" + lecturer.getEmail() + "','"
					+ lecturer.getPhoneNumber() + "','" + lecturer.getAddress() + "','" + lecturer.getDescription() + "');";
			
			PreparedStatement ps1 = conn.prepareStatement(insertQuery1);
			ps1.executeUpdate();
			ps1.close();
		} catch (Exception e) {
            String error = "Error creating lecturer. Nested Exception is: " + e;
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
	public void deleteLecturer(int lecturerID) throws DAOException{
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		try{
			String deleteQuery="delete from caps.lecturer where lecturerID=?";
			PreparedStatement ps1=conn.prepareStatement(deleteQuery);
			 ps1.setInt(1, lecturerID);
			ps1.executeUpdate();
			ps1.close();
			
			String deleteQuery2="delete from caps.user where userID=?";
			PreparedStatement ps2=conn.prepareStatement(deleteQuery2);
			ps2.setInt(1, lecturer.getUserID());
			ps2.executeUpdate();
			ps2.close();

		}catch(Exception e){
			String error ="Error deleting lecturer. Nested Exception is: " +e;
			new DAOException(error);
		}
	}

	@Override
	public void updateLecturer(LecturerDTO lecturer,User user) throws DAOException{
	try {
		conn = DAOConnection.openConnection();
	} catch (DAOException e1) {
		e1.printStackTrace();
	}

	        try {
	        	/*
	        	String query2 = "update user set userName=?, password=? where user.userId=?";
		        PreparedStatement preparedStatement2 = conn.prepareStatement( query2 );
		        preparedStatement2.setString( 1, lecturer.getUserName() );
		        preparedStatement2.setString( 2, lecturer.getPassword() );
		        preparedStatement2.setInt(3, lecturer.getUserID());
		        preparedStatement2.executeUpdate();
		        preparedStatement2.close();*/
		        
	        	String query1 = "update lecturer set firstName=?, lastName=?, email=?, phoneNumber=?, address=?, description=? where lecturerID=?";
	            PreparedStatement preparedStatement1 = conn.prepareStatement( query1 );
	            preparedStatement1.setString( 1, lecturer.getFirstName() );
	            preparedStatement1.setString( 2, lecturer.getLastName() );
	            preparedStatement1.setString( 3, lecturer.getEmail());
	            preparedStatement1.setInt( 4, lecturer.getPhoneNumber());
	            preparedStatement1.setString(5, lecturer.getAddress());
	            preparedStatement1.setString(6,lecturer.getDescription());
	            preparedStatement1.setInt(7, lecturer.getLecturerID());
	            preparedStatement1.executeUpdate();
	            preparedStatement1.close();

	        } catch (Exception e) {
	            String error = "Error updating lecturer. Nested Exception is:" +e;
	            new DAOException(error);
	        }
	}
	
}