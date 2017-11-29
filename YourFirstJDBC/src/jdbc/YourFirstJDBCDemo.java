package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;

public class YourFirstJDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Driver
		Class.forName("com.mysql.jdbc.Driver");
		// Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa45demo?useSSL=false", "root", "password");
		// Statement
		Statement statement = connection.createStatement();
		// Query
		ResultSet rs = statement.executeQuery("SELECT * FROM sa45demo.student;");
		// Processing
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt(1));
			student.setName(rs.getString("name"));
			student.setNickName(rs.getString(3));
			System.out.println(student.toString());
		}
		// Releasing Resources
		statement.close();
		connection.close();

	}

}
