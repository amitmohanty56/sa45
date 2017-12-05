package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDTO;
import model.EnrollmentDTO;
import model.User;
import service.CourseManager;
import service.EnrollManager;

/**
 * Servlet implementation class EnrollCourseServlet
 */
@WebServlet("/EnrollCourseServlet")
public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
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
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		
		
		User loginUser = (User)request.getSession().getAttribute("profile");
		int userID = loginUser.getUserId().intValue();

		RequestDispatcher rd = request.getRequestDispatcher("ListCourseServlet");

		CourseManager cm = new CourseManager();
		CourseDTO course = cm.findCourseByID(courseID);

		EnrollManager em = new EnrollManager();
		int studentID=em.findStudentIDByUserID(userID);
		
		boolean hasStudentEnrolled = em.hasStudentEnrolled(studentID, courseID);
		if (hasStudentEnrolled) {
			request.setAttribute("isAbleToEnroll", -1);
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (course.getClassSize() <= course.getEnrolledSize()) {
				try {
					request.setAttribute("isAbleToEnroll", 0);
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				
				em.insertEnrollment(studentID, courseID);
				course.setEnrolledSize(course.getEnrolledSize() + 1);
				cm.updateCourseEnrolledSize(course);
				request.setAttribute("isAbleToEnroll", 1);
								
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
