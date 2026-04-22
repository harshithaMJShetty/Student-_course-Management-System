package com.main;

import java.sql.Date;
import java.util.Scanner;

import models.Enrollments;
import models.Students;
import myCrud.CourseCRUD;
import myCrud.EnrollmentCRUD;
import myCrud.StudentCRUD;

public class Studentmenu {

	 private StudentCRUD studentCrud = new StudentCRUD();
	    private CourseCRUD courseCrud = new CourseCRUD();
	    private EnrollmentCRUD enrollmentCrud = new EnrollmentCRUD();

	    public void show() {

	        Scanner sc = new Scanner(System.in);

	        while (true) {

	            System.out.println("\n========== STUDENT MENU ==========");
	            System.out.println("1. Register New Student");
	            System.out.println("2. Update Student Profile");
	            System.out.println("3. Enroll in Course");
	            System.out.println("4. View Enrolled Courses");
	            System.out.println("5. View Grades");
	            System.out.println("6. View GPA");
	            System.out.println("7. Exit");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    System.out.println("Enter name:");
	                    String name = sc.nextLine();

	                    System.out.println("Enter email:");
	                    String email = sc.nextLine();

	                    System.out.println("Enter dob (yyyy-mm-dd):");
	                    Date dob = Date.valueOf(sc.nextLine());

	                    Students s = new Students(0, name, email, dob);
	                    studentCrud.single_insertStudents(s);
	                    break;

	                case 2:
	                    System.out.println("Enter your student id:");
	                    int sidUpdate = sc.nextInt();
	                    sc.nextLine();

	                    System.out.println("Enter new name:");
	                    String newName = sc.nextLine();

	                    System.out.println("Enter new email:");
	                    String newEmail = sc.nextLine();

	                    System.out.println("Enter new dob (yyyy-mm-dd):");
	                    Date newDob = Date.valueOf(sc.nextLine());

	                    Students updatedStudent = new Students(sidUpdate, newName, newEmail, newDob);
	                    studentCrud.updateStudent(updatedStudent);
	                    break;

	                case 3:
	                    System.out.println("Enter your student id:");
	                    int sid = sc.nextInt();

	                    System.out.println("Enter course id:");
	                    int courseId = sc.nextInt();
	                    sc.nextLine();

	                    Enrollments e = new Enrollments(sid, courseId, "NA");
	                    enrollmentCrud.insertEnrollment(e);
	                    break;

	                case 4:
	                    System.out.println("Enter your student id:");
	                    int sidView = sc.nextInt();
	                    sc.nextLine();

	                    enrollmentCrud.getStudentEnrollments(sidView);
	                    break;
	                
	                case 5:
	        			System.out.println("Enter your student Id");
	        			int gid=sc.nextInt();
	        			enrollmentCrud.viewGrade(gid);
	        			break;
	        			
	        		case 6:
	        			System.out.println("Enter your student Id");
	        			int aid=sc.nextInt();
	        			enrollmentCrud.avggpa(aid);;
	        			break;
//	                case 5:
//	                    System.out.println("Enter your student id:");
//	                    int sidGrade = sc.nextInt();
//	                    sc.nextLine();
	//
//	                    enrollmentCrud.getStudentGrades(sidGrade);
//	                    break;
	//
//	                case 6:
//	                    System.out.println("Enter your student id:");
//	                    int sidGpa = sc.nextInt();
//	                    sc.nextLine();
	//
//	                    enrollmentCrud.getStudentGPA(sidGpa);
//	                    break;

	                case 7:
	                    System.out.println("Exiting Student Menu...");
	                    return;

	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}


