package javabeans;

import model.*;
import java.util.*;

public class CourseAndStudents {
	public CourseDTO course;
	public ArrayList<EnrollmentDetails> lstEnrollments;

	public CourseAndStudents(CourseDTO course, ArrayList<EnrollmentDetails> lstEnrollments) {
		super();
		this.course = course;
		this.lstEnrollments = lstEnrollments;
	}
}
