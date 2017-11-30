package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

//import model.Student;

/**
 * Servlet implementation class YourDisplayServlet
 */
@WebServlet({ "/display", "/view", "/show*" })
public class YourDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YourDisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html> <body> <h1> My First Servlet!!</h1>");
		out.println("name is " + request.getParameter("name"));
		out.println("preference is " + request.getParameter("pref"));

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
				out.println(student.toString());
			}
			// Releasing Resources
			statement.close();
			connection.close();

			out.println("<br/>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("<br/>");
		out.append("Served at: ").append(request.getContextPath());

	}

}
