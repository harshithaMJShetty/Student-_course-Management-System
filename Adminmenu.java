package com.main;

import java.util.Scanner;

import models.Courses;
import myCrud.CourseCRUD;
import myCrud.EnrollmentCRUD;
import myCrud.StudentCRUD;

public class Adminmenu {
	private StudentCRUD studentCrud = new StudentCRUD();
    private CourseCRUD courseCrud = new CourseCRUD();
    private EnrollmentCRUD enrollmentCrud = new EnrollmentCRUD();
    public void show() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View All Students");
            System.out.println("5. View All Courses");
            System.out.println("6. View All Enrollments");
            System.out.println("7. Assign Grade");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter course name:");
                    String cname = sc.nextLine();

                    System.out.println("Enter credits:");
                    int credits = sc.nextInt();
                    sc.nextLine();

                    Courses course = new Courses(cname, credits);
                    courseCrud.insertCourse(course);
                    break;

                case 2:
                    System.out.println("Enter course id:");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter new course name:");
                    String newName = sc.nextLine();

                    System.out.println("Enter new credits:");
                    int newCredits = sc.nextInt();
                    sc.nextLine();

                    Courses updatedCourse = new Courses(cid, newName, newCredits);
                    courseCrud.updateCourse(updatedCourse);
                    break;

                case 3:
                    System.out.println("Enter course id to delete:");
                    int delCid = sc.nextInt();
                    sc.nextLine();

                    courseCrud.deleteCourse(delCid);
                    break;

                case 4:
                    studentCrud.getAllStudents();
                    break;

                case 5:
                    courseCrud.getAllCourses();
                    break;

                case 6:
                    enrollmentCrud.getAllEnrollments();
                    break;

                case 7:
                    System.out.println("Enter your student id:");
                    int ustu_id = sc.nextInt();
                    
                    
                    System.out.println("Enter your course id:");
                    int ucou_id = sc.nextInt();
                    

                    System.out.println("Enter grade:");
                    String ugrade = sc.next();

                    enrollmentCrud.updateGrade(ustu_id, ucou_id, ugrade);
                    break;
                   

                case 8:
                    System.out.println("Exiting Admin Menu...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


