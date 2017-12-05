package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDTO;
import model.User;
import service.EmailService;
import service.StudentManager;
import utility.GeneratePassword;

/**
 * Servlet implementation class StudentSetup
 */
@WebServlet("/StudentSetup")
public class StudentSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String students_list = "views/administrator_module/studentList.jsp";
	public static final String insert_edit = "views/administrator_module/studentSetup.jsp";
	
	String forward = null;
	StudentManager studentMgr = new StudentManager();
	StudentDTO student = new StudentDTO();
	User user = new User();
	
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
	public StudentSetup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("deleteStudent")){
			forward = students_list;
			//forward = "views/administrator_module/studentsList.jsp";
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			studentMgr.deleteStudent(studentID);
			request.setAttribute("studentList", studentMgr.getStudentList());
			
		}else if (action.equalsIgnoreCase("editStudent")){
			//forward = "views/administrator_module/studentSetup.jsp";
			forward = insert_edit;
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			StudentDTO student = new StudentDTO();
			student = studentMgr.getStudent(studentID);
			request.setAttribute("student", student);
			
	     }else if (action.equalsIgnoreCase("addStudent")) {
	    	 forward = insert_edit;
			//forward = "/views/administrator_module/studentSetup.jsp";
			
		 }else {
			 forward = students_list;
			//forward = "/views/administrator_module/studentsList.jsp";
			request.setAttribute("studentList", studentMgr.getStudentList());
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//getting auto generate password
		GeneratePassword gp = new GeneratePassword();
		String userPassword = gp.randomPassword(6);
				
		
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setEmail(request.getParameter("email"));
		student.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
		student.setAddress(request.getParameter("address"));
		
		String studentID = request.getParameter("studentID");
		String userID = request.getParameter("userID");
		
        if(studentID == null || studentID.isEmpty() ||userID==null || userID.isEmpty())
        {
        	DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
			Calendar cal = Calendar.getInstance();
			String currentDateTime = dateFormat.format(cal.getTime());
			String studentUserName = request.getParameter("firstName") + currentDateTime;
        	
        	student.setUserName(studentUserName);
    		student.setPassword(userPassword);
        	
        	studentMgr.addStudent(user, student);
            
	          //sending email..
        	String studentName = request.getParameter("firstName");
			String recipient = request.getParameter("email");
			EmailService emailService = new EmailService();
		    emailService.sendEmailToStudent(host, port, gmail_user, pass,studentName, studentUserName, recipient, userPassword);
            
        } 
        else {
        	
        	student.setUserID(Integer.parseInt(userID));
            student.setStudentID(Integer.parseInt(studentID));
            
            studentMgr.updateStudent(student);
        }
        
        request.setAttribute("studentList", studentMgr.getStudentList());
        //RequestDispatcher rd = request.getRequestDispatcher("/views/administrator_module/studentList.jsp");
        //rd.forward(request, response);
        response.sendRedirect("/caps/ListStudentServlet");
	}

}
