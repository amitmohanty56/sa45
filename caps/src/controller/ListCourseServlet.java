package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseManager;
import service.EnrollManager;
import model.CourseDTO;
import model.User;

/**
 * Servlet implementation class ListCourseServlet
 */
@WebServlet("/ListCourseServlet")
public class ListCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String path;
		
		
		
		CourseManager cm = new CourseManager();
		EnrollManager em = new EnrollManager();
		
		User loginUser = (User)request.getSession().getAttribute("profile");
		System.out.print(loginUser);
		if(loginUser != null){
			int loginUserID = loginUser.getUserId().intValue();
			if(loginUser.getRole().equals("administrator")){
				ArrayList<CourseDTO> courses = cm.getCourseList();
				request.setAttribute("courses", courses);
				path = "/views/administrator_module/list.jsp";
			}
			else{
				int studentID = em.findStudentIDByUserID(loginUserID);
				ArrayList<CourseDTO> courses = cm.getCourseListNotEnrolled(studentID);
				request.setAttribute("courses", courses);
				path = "/views/student_module/home.jsp";
			}
		}
		else{
			System.out.println("not yet logged in");
			path = "/views/login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
