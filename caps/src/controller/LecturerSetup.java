package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.LecturerDAO;
import dao.LecturerSetupDAO;
import dao.mysql.LecturerSetupDAOImpl;
import dao.mysql.MySQLConstants;
import exception.DAOException;
import service.CourseManager;
import service.EmailService;
import service.LecturerManager;
import service.LecturerSetupManager;
import utility.GeneratePassword;
import model.CourseDTO;
import model.LecturerDTO;
import model.User;

/**
 * Servlet implementation class LecturerSetup
 */
@WebServlet("/LecturerSetup")
public class LecturerSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String lecturer_list = "/views/administrator_module/LecturerList.jsp";
	public static final String insert_edit = "/views/administrator_module/lecturerSetup.jsp";  
	
	LecturerSetupManager lsm = new LecturerSetupManager();
	LecturerManager lm = new LecturerManager();
	User user = new User();
	LecturerDTO lecturer = new LecturerDTO();
	private LecturerSetupDAO lecSetupDAO;
	
	//smtp setting
	private String host;
	private String port;
	private String gmail_user;
	private String pass;
	
	public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        gmail_user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
	 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerSetup() {
    	super();
    	lecSetupDAO = new LecturerSetupDAOImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			forward = insert_edit;
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			forward = insert_edit;
			int lecturerID = Integer.parseInt(request.getParameter("lecturerID"));
			LecturerDTO lecturer = lm.getLecturerByID(lecturerID);
			request.setAttribute("lecturer", lecturer);
		}
		else if( action.equalsIgnoreCase( "delete" ) )
		{
            forward = lecturer_list;
            int lecturerID = Integer.parseInt( request.getParameter("lecturerID") );
            lsm.deleteLecturer(lecturerID);
            request.setAttribute("lecturers", lm.getLecturerList() );
        }
    
		else
		{
			forward = lecturer_list;
			request.setAttribute("lecturers", lm.getLecturerList());
			
		}
			RequestDispatcher rd = request.getRequestDispatcher( forward );
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting auto generate password
		GeneratePassword gp = new GeneratePassword();
		String userPassword = gp.randomPassword(6);
		
		lecturer.setFirstName(request.getParameter("firstName"));
		lecturer.setLastName(request.getParameter("lastName"));
		lecturer.setEmail(request.getParameter("email"));
		lecturer.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
		lecturer.setAddress(request.getParameter("address"));
		lecturer.setDescription(request.getParameter("description"));
		
		
		String lecturerID = request.getParameter("lecturerID");
		String userID = request.getParameter("userID");
		
		if(lecturerID==null || lecturerID.isEmpty() ||userID==null||userID.isEmpty()){
			DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
			Calendar cal = Calendar.getInstance();
			String currentDateTime = dateFormat.format(cal.getTime());
			String lecturerUserName = request.getParameter("firstName") + currentDateTime;
				
			lecturer.setUserName(lecturerUserName);
			lecturer.setPassword(userPassword);
				
			lsm.addLecturer(user,lecturer);
				
			//sending email
			String lecturerName = request.getParameter("firstName");
			String recipient = request.getParameter("email");
				   
			EmailService emailService = new EmailService();
		       emailService.sendEmailToStudent(host, port, gmail_user, pass,lecturerName, lecturerUserName, recipient, userPassword);
				
		}else{
			lecturer.setUserID(Integer.parseInt(request.getParameter("userID")));
			lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerID")));
			lsm.updateLecturer(lecturer,user);
			
		}
		request.setAttribute("lecturers", lm.getLecturerList());
		response.sendRedirect("/caps/ListLecturerServlet");
		
	}
		
}


