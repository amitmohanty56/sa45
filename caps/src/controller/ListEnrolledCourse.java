package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.CourseManager;
import model.CourseDTO;
import model.EnrolledCourseDTO;

/**
 * Servlet implementation class ListEnrolledCourse
 */
@WebServlet("/ListEnrolledCourse")
public class ListEnrolledCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEnrolledCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		User loginUser = (User)request.getSession().getAttribute("profile");
		Long loginID = loginUser.getUserId();
		int studentId = loginID.intValue(); // login userID of student
		
		CourseManager cm = new CourseManager();
		ArrayList<EnrolledCourseDTO> courses = cm.findCourseByStudentId(studentId);
		
		request.setAttribute("courses", courses);
		
		String path = "/views/student_module/enrollcourses.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		try{
			rd.forward(request, response);
		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
