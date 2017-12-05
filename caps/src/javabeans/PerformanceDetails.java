package javabeans;

import java.util.Date;

public class PerformanceDetails {
	private int studentID;
	private String firstName;
	private String lastName;
	private String courseCode;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private String grade;
	private int credit;

	public PerformanceDetails(int studentID, String firstName, String lastName, String courseCode, String courseName,
			Date startDate, Date endDate, String grade, int credit) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.credit = credit;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
