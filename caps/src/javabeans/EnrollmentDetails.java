package javabeans;

public class EnrollmentDetails {

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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	private int studentID;
	private String firstName;
	private String lastName;
	private String emailID;
	private String phoneNumber;
	private String grade;
	private int credit;

	public EnrollmentDetails(int studentID, String firstName, String lastName, String emailID, String phoneNumber,
			String grade, int credit) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.credit = credit;
	}

}
