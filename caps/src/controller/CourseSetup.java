package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.mysql.CourseDAOImpl;
import exception.DAOException;
import service.CourseManager;
import model.CourseDTO;
import model.LecturerDTO;
import service.LecturerManager;

/**
 * Servlet implementation class CourseSetup
 */
@WebServlet("/CourseSetup")
public class CourseSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String course_list = "/views/administrator_module/list.jsp";
	public static final String insert_edit = "/views/administrator_module/coursesetup.jsp";  
	
	CourseManager cm = new CourseManager();
	LecturerManager lm = new LecturerManager();
	CourseDTO course = new CourseDTO();
	LecturerDTO lecturer = new LecturerDTO();
	CourseDAO cdao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSetup() {
        super();
        cdao = new CourseDAOImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert")){
			forward = insert_edit;
			request.setAttribute("lecturers",lm.getLecturerList());
		}
		else if(action.equalsIgnoreCase("edit")){
			forward = insert_edit;
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			CourseDTO currentcourse = cm.findCourseByID(courseId);
			request.setAttribute("course", currentcourse);
			request.setAttribute("lecturers",lm.getLecturerList());
			
		}
		else if(action.equalsIgnoreCase("delete")){
			forward = course_list;
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			cm.deleteCourse(courseId);
			request.setAttribute("courses", cm.getCourseList());
		}
		else{
			forward = course_list;
			request.setAttribute("courses", cm.getCourseList());
			
		}
		//response.sendRedirect(forward);
		RequestDispatcher rd = request.getRequestDispatcher( forward );
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		course.setCourseCode(request.getParameter("courseCode"));
		course.setCourseName(request.getParameter("courseName"));
		course.setLecturerID(Integer.parseInt(request.getParameter("lecturerID")));
		course.setStartdate(request.getParameter("startdate"));
		course.setEnddate(request.getParameter("enddate"));
		course.setClassSize(Integer.parseInt(request.getParameter("classsize")));
		course.setCredit(Integer.parseInt(request.getParameter("credit")));
		
		
		String courseID = request.getParameter("courseId");
		
		if( courseID == null || courseID.isEmpty()){
			cm.insertCourse(course);
		}
		else{
			course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
			cm.updateCourse(course);
		}
		
		request.setAttribute("courses", cm.getCourseList());
		response.sendRedirect("/caps/ListCourseServlet");
		
	}

}
