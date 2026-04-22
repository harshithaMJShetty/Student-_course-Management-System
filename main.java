package com.main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        Adminmenu adminMenu = new Adminmenu();
	        Studentmenu studentMenu = new Studentmenu();

	        int choice;

	        while (true) {

	            System.out.println("\n=========== MAIN MENU ===========");
	            System.out.println("1. Admin Menu");
	            System.out.println("2. Student Menu");
	            System.out.println("3. Exit");

	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    adminMenu.show();
	                    break;

	                case 2:
	                    studentMenu.show();
	                    break;

	                case 3:
	                    System.out.println("Thank you... Exiting System.");
	                    sc.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid Choice");
	            }
	        }
	    }
	
		// TODO Auto-generated method stub

	}


