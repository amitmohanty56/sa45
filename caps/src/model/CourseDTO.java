package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CourseDTO implements Serializable{
	
	private int courseId;
	private String courseCode;
	private String courseName;
	private int classSize;
	private Date startDate;
	private Date endDate;
	private int enrolledSize;
	private int credit;
	
	private String startdate;
	private String enddate;
	

	private String firstName;
	private String lastName;
	private String lecturerName;
	private int lecturerID;
	
	private int isEnrolled;
	
	public int getIsEnrolled() {
		return isEnrolled;
	}

	public void setIsEnrolled(int isEnrolled) {
		this.isEnrolled = isEnrolled;
	}

	public CourseDTO(){
		
	}
	
	public CourseDTO(int courseID, String courseCode, String courseName, int classSize, Date startDate, Date endDate,
			int lecturerID, int enrolledSize, int credit) {
		super();
		this.courseId = courseID;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.classSize = classSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lecturerID = lecturerID;
		this.enrolledSize = enrolledSize;
		this.credit = credit;
	}
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	public int getClassSize() {
		return classSize;
	}
	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getEnrolledSize() {
		return enrolledSize;
	}
	public void setEnrolledSize(int enrolledSize) {
		this.enrolledSize = enrolledSize;
	}
	
	
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	// getting lecturer's firstname / last name/ id
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
	public String getLecturerName() {
		return getFirstName() + " " + getLastName();
	}
	public void setLecturerName(String lecturerName){
		this.lecturerName = lecturerName;
	}
	public int getLecturerID() {
		return lecturerID;
	}
	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
	
}
