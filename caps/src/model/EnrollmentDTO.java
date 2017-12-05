package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnrollmentDTO implements Serializable{
	
	private String grade;
	private String credit;
	private String status;
	private int courseID;
	private int studentID;
	private int enrollmentID;
	
	public int getEnrollmentID() {
		return enrollmentID;
	}
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Enrollment [grade=" + grade + ", credit=" + credit + ", status=" + status + "]";
	}
	
	
	
	
}
