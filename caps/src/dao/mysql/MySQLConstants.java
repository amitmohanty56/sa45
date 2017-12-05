package dao.mysql;

public class MySQLConstants {

	public static final String URL = "jdbc:mysql://localhost:3306/caps?useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String DB_TYPE = "MySql";

	public static final String DATABASE_NAME = "caps.";

	public static final String CAPS_TABLE_LECTURER = DATABASE_NAME + "lecturer";
	public static final String CAPS_LECTURER_COL_LECTURERID = "lecturerID";
	public static final String CAPS_LECTURER_COL_USERID = "userID";
	public static final String CAPS_LECTURER_COL_FNAME = "firstName";
	public static final String CAPS_LECTURER_COL_LNAME = "lastName";
	public static final String CAPS_LECTURER_COL_EMAIL = "email";
	public static final String CAPS_LECTURER_COL_PH = "phoneNumber";
	public static final String CAPS_LECTURER_COL_ADDRESS = "address";
	public static final String CAPS_LECTURER_COL_DESC = "description";

	public static final String CAPS_TABLE_COURSE = DATABASE_NAME + "course";
	public static final String CAPS_COURSE_COL_CourseID = "courseID";
	public static final String CAPS_COURSE_COL_COURSECODE = "courseCode";
	public static final String CAPS_COURSE_COL_COURSENAME = "courseName";
	public static final String CAPS_COURSE_COL_CLASSSIZE = "classSize";
	public static final String CAPS_COURSE_COL_LECTURERID = "lecturerID";
	public static final String CAPS_COURSE_COL_STARTDATE = "startDate";
	public static final String CAPS_COURSE_COL_ENDDATE = "endDate";
	public static final String CAPS_COURSE_COL_ENROLLSIZE = "enrollSize";
	public static final String CAPS_COURSE_COL_CREDIT = "credit";

	public static final String CAPS_TABLE_ENROLLMENT = DATABASE_NAME + "enrollment";
	public static final String CAPS_ENROLLMENT_COL_enrollmentID = "enrollmentID";
	public static final String CAPS_ENROLLMENT_COL_courseID = "courseID";
	public static final String CAPS_ENROLLMENT_COL_studentID = "studentID";
	public static final String CAPS_ENROLLMENT_COL_grade = "grade";
	public static final String CAPS_ENROLLMENT_COL_credit = "credit";
	public static final String CAPS_ENROLLMENT_COL_status = "status";
	
	public static final String CAPS_TABLE_STUDENT = DATABASE_NAME + "student";
	public static final String CAPS_STUDENT_COL_StudentID = "studentID";
	public static final String CAPS_STUDENT_COL_userID = "userID";
	public static final String CAPS_STUDENT_COL_firstName = "firstName";
	public static final String CAPS_STUDENT_COL_lastName = "lastName";
	public static final String CAPS_STUDENT_COL_email = "email";
	public static final String CAPS_STUDENT_COL_phoneNumber = "phoneNumber";
	public static final String CAPS_STUDENT_COL_address = "address";
	
	
	public static final String CAPS_TABLE_USER = DATABASE_NAME + "user";
	public static final String CAPS_USER_COL_USERID = "userID";
	public static final String CAPS_USER_COL_USERNAME = "userName";
	public static final String CAPS_USER_COL_PASSWORD = "password";
	public static final String CAPS_USER_COL_ROLE = "role";
	
}
