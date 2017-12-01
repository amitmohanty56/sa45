package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class StudentLoadServlet
 */
@WebServlet("/loaddata")
public class StudentLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentLoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> al = new ArrayList<Student>();
		// Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa45demo?useSSL=false",
					"root", "password");
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
				al.add(student);
			}
			// Releasing Resources
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Attach the data to request scope????
		request.setAttribute("slist", al);
		RequestDispatcher rd = request.getRequestDispatcher("/DisplayStudents.jsp");
		rd.forward(request, response);

	}

}
