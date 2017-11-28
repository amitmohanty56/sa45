package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import simple.Student;
import simple.StudentNameComparator;

public class TestModel {

	public static void main(String[] args) {
		Student s1 = new Student(22, "CHEN QIANYU", "charlotte");
		Student s2 = new Student(24, "HTOO EI EI KHAING", "h2o");
		Student s3 = new Student(11, "KRISHNAMURTHY URMILA", "mi");
		Student s4 = new Student(3, "K URMILA", "mi");
		if (s3.equals(s4)) {
			System.out.println("Same Urmila");
		} else {
			System.out.println("Digital Twin");
		}
			
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(s1); slist.add(s2); slist.add(s3);
		System.out.println("COMPARABLE");
		
		System.out.println("********************* B4 SORTING");
		for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.toString());
			
		}
		Collections.sort(slist);
		System.out.println("********************* AFTER SORTING");
		for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.toString());
			
		}
		Collections.reverse(slist);
		System.out.println("********************* AFTER SORTING");
		for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.toString());
			
		}
		
		System.out.println("COMPARATOR");
		//ArrayList<Student> nlist = new ArrayList<Student>();
		Collections.sort(slist, new StudentNameComparator());
		System.out.println("********************* AFTER COMPARATOR");
		for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.toString());
			
		}
	}

}
