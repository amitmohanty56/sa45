package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DAOConnection;
import dao.StudentDAO;
import exception.DAOException;
import model.StudentDTO;
import model.User;

public class StudentDAOImpl implements StudentDAO {

	private static Connection conn;
	StudentDTO student = new StudentDTO();
	
	
	public void addStudentOne(User user, StudentDTO student) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		try{
			String insertQuery2 = "insert into user (userName, password,role) values (?,?,?)";
			PreparedStatement ps2 = conn.prepareStatement(insertQuery2);
			ps2.setString(1, student.getUserName());
			ps2.setString(2, student.getPassword());
			ps2.setString(3,"student");
			
			ps2.executeUpdate();
			ps2.close();
			
			String insertQuery1= "INSERT INTO student "
					+ "(userId, firstName, lastName, email, phoneNumber, address) " + "VALUES ("
					+ "LAST_INSERT_ID() ,'" + student.getFirstName() + "','" + student.getLastName() + "','" + student.getEmail() + "','"
					+ student.getPhoneNumber() + "','" + student.getAddress() + "');";
			
			PreparedStatement ps1 = conn.prepareStatement(insertQuery1);
			ps1.executeUpdate();
			ps1.close();
		} catch (SQLException e) {
	        e.printStackTrace();
    }
			
	}

	public void deleteStudent(int studentID) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		try{
			String deleteQuery="delete from caps.student where studentID=?";
			PreparedStatement ps1=conn.prepareStatement(deleteQuery);
			 ps1.setInt(1, studentID);
			ps1.executeUpdate();
			ps1.close();
			
			String deleteQuery2="delete from caps.user where userID=?";
			PreparedStatement ps2=conn.prepareStatement(deleteQuery2);
			ps2.setInt(1, student.getUserID());
			ps2.executeUpdate();
			ps2.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
		
			
	}

	public void updateStudent(StudentDTO student) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}

        try {
        	
        	/*String query2 = "update user set userName=?, password=? where user.userId=?";
	        PreparedStatement preparedStatement2 = connection.prepareStatement( query2 );
	        preparedStatement2.setString( 1, student.getUserName() );
	        preparedStatement2.setString( 2, student.getPassword() );
	        preparedStatement2.setInt(3, student.getUserID());
	        preparedStatement2.executeUpdate();
	        preparedStatement2.close();*/
	        
        	String query1 = "update student set firstName=?, lastName=?, email=?, phoneNumber=?, address=? where studentID=?";
            PreparedStatement preparedStatement1 = conn.prepareStatement( query1 );
            preparedStatement1.setString( 1, student.getFirstName() );
            preparedStatement1.setString( 2, student.getLastName() );
            preparedStatement1.setString( 3, student.getEmail());
            preparedStatement1.setInt( 4, student.getPhoneNumber());
            preparedStatement1.setString(5, student.getAddress());
            
            preparedStatement1.setInt(6, student.getStudentID());
            preparedStatement1.executeUpdate();
            preparedStatement1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
			

	}

	public ArrayList<StudentDTO> findAllStudents() throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		ArrayList<StudentDTO> students=new ArrayList<StudentDTO>();
		try
		{
			Statement statement=conn.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM caps.student INNER JOIN caps.user ON caps.student.userId = caps.user.userId");
			while(resultSet.next()){
				StudentDTO student=new StudentDTO();
				student.setUserID(resultSet.getInt(MySQLConstants.CAPS_STUDENT_COL_userID));
				student.setStudentID(resultSet.getInt(MySQLConstants.CAPS_STUDENT_COL_StudentID));
				student.setFirstName(resultSet.getString(MySQLConstants.CAPS_STUDENT_COL_firstName));
				student.setLastName(resultSet.getString(MySQLConstants.CAPS_STUDENT_COL_lastName));
				student.setEmail(resultSet.getString(MySQLConstants.CAPS_STUDENT_COL_email));
				student.setPhoneNumber(resultSet.getInt(MySQLConstants.CAPS_STUDENT_COL_phoneNumber));
				student.setAddress(resultSet.getString(MySQLConstants.CAPS_STUDENT_COL_address));
				student.setUserName(resultSet.getString(MySQLConstants.CAPS_USER_COL_USERNAME));
				student.setPassword(resultSet.getString(MySQLConstants.CAPS_USER_COL_PASSWORD));
				students.add(student);
			}
			resultSet.close();
			statement.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return students;
	}

	public StudentDTO findStudentOne(int id) throws SQLException {
		try {
			conn = DAOConnection.openConnection();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
	     
        try {
        	String query1 = "select * from user,student where user.userID=student.userID and student.studentID=?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement( query1 );
            preparedStatement1.setInt(1,id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while( resultSet1.next() ) {
                student.setFirstName(resultSet1.getString(MySQLConstants.CAPS_STUDENT_COL_firstName));
                student.setLastName( resultSet1.getString(MySQLConstants.CAPS_STUDENT_COL_lastName ) );
                student.setEmail( resultSet1.getString( MySQLConstants.CAPS_STUDENT_COL_email ) );
                student.setPhoneNumber(resultSet1.getInt(MySQLConstants.CAPS_STUDENT_COL_phoneNumber));
                student.setAddress(resultSet1.getString(MySQLConstants.CAPS_STUDENT_COL_address));
                student.setStudentID(resultSet1.getInt(MySQLConstants.CAPS_STUDENT_COL_StudentID));
                
                student.setUserName(resultSet1.getString("userName"));
				student.setPassword(resultSet1.getString("password"));
				student.setUserID(resultSet1.getInt("userID"));
                
               //user.setName(resultSet1.getString("userName"));
               //user.setName(resultSet1.getString("password"));
                		            }
            resultSet1.close();
            preparedStatement1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
	}
}