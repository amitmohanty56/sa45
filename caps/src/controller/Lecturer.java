package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.CourseAndStudents;
import javabeans.PerformanceDetails;
import model.CourseDTO;
import model.EnrollmentDTO;
import model.User;
import service.LecturerManager;

/**
 * Servlet implementation class Lecturer
 */
@WebServlet(name = "lecturer/*", urlPatterns = { "/lecturer/*", "/lecturer" })
public class Lecturer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {

			String path = request.getPathInfo();
			RequestDispatcher rd = null;
			String lecturerID, courseID, studentID = null;
			LecturerManager lSvc = new LecturerManager();
			switch (path) {
			case "/courses":
			case "/":
				
				User lu = (User)request.getSession().getAttribute("profile");
				ArrayList<CourseDTO> clist = lSvc.getAllCoursesByLecturer(lu.getUserId().intValue());
				
				request.setAttribute("clist", clist);
				rd = request.getRequestDispatcher("/views/lecturer_module/home.jsp");
				rd.forward(request, response);
				break;
			case "/coursedetail":
				courseID = request.getParameter("courseID");
				CourseAndStudents casObj = lSvc.getCourseAndStudentByCourseID(Integer.parseInt(courseID));
				request.setAttribute("course", casObj.course);
				request.setAttribute("lstStudents", casObj.lstEnrollments);
				rd = request.getRequestDispatcher("/views/lecturer_module/coursedetail.jsp");
				rd.forward(request, response);
				break;
			case "/saveGrade":
				studentID = request.getParameter("studentIDHdn");
				courseID = request.getParameter("courseIDHdn");
				String grade = request.getParameter("gradeHdn");
				lSvc.gradeEnrollment(Integer.parseInt(studentID), Integer.parseInt(courseID), grade);
				casObj = lSvc.getCourseAndStudentByCourseID(Integer.parseInt(courseID));
				request.setAttribute("course", casObj.course);
				request.setAttribute("lstStudents", casObj.lstEnrollments);
				rd = request.getRequestDispatcher("/views/lecturer_module/coursedetail.jsp");
				rd.forward(request, response);
				break;
			case "/performance":
				String S = request.getParameter("studentid");
				String name = request.getParameter("studentname");
				LecturerManager L = new LecturerManager();
				int stuId = this.tryParse(S);
				ArrayList<PerformanceDetails> elist = L.getEnrollmentsByStudentID(stuId, name);
				request.setAttribute("elist", elist);
				rd = request.getRequestDispatcher("/views/lecturer_module/performance.jsp");
				rd.forward(request, response);
				break;
			default:
				break;
			}
		} catch (NumberFormatException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	public Integer tryParse(String obj) {
		Integer retVal;
		try {
			retVal = Integer.parseInt(obj);
		} catch (NumberFormatException nfe) {
			retVal = 0; // or null if that is your preference
		}
		return retVal;
	}

	public void RedirectFailurePage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("");
		try {
			rd.forward(request, response);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
