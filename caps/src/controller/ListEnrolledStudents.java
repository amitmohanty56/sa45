package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.CourseAndStudents;
import service.LecturerManager;

/**
 * Servlet implementation class ListEnrolledStudents
 */
@WebServlet("/ListEnrolledStudents")
public class ListEnrolledStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEnrolledStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response){
		int courseID = Integer.parseInt(request.getParameter("courseId"));
		LecturerManager lm = new LecturerManager();
		CourseAndStudents casObj = lm.getCourseAndStudentByCourseID(courseID);
		request.setAttribute("course", casObj.course);
		request.setAttribute("lstStudents", casObj.lstEnrollments);
		String path = "/views/administrator_module/enrolledStudents.jsp";
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