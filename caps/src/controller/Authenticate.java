package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.NotFoundException;
import model.User;
import service.UserService;
import utility.GeneratePassword;
import service.EmailService;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
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
		String path;
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		
		User user = new User();
		user.setName(u);
		user.setPassword(p);
		
		UserService service;
		User loginUser;
		try {
		 	 service = new UserService();
	    	 loginUser = service.authenticate(user);
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("profile", loginUser);
	    	 
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		if(service.checkLoginUser(user)){
			User lu = (User)request.getSession().getAttribute("profile");
			if (lu.getRole().equals("student")){	
				path = "/ListCourseServlet";
				
			}
			else if(lu.getRole().equals("lecturer")){
				path ="/lecturer/";
			}
			else{
				path = "/ListCourseServlet";
			}
		}
		else{
			request.setAttribute("error","Invalid Username or Password !!");
			path = "/views/login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
