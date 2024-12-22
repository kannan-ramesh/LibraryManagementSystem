package com.kannanrameshrk;

import java.util.Scanner;

import com.kannanrameshrk.libray.LibraryManageView;
import com.kannanrameshrk.repository.Repository;

public class Main {
	public static void main(String[] args) {
		System.out.println("\t\t Library Management System");
		System.out.println("\t\t****************************");
		Scanner input=new Scanner(System.in);
		Repository.getInstance().add();
		
		while(true) {
			System.out.println("Enter Role(admin/user):");
			String role=input.nextLine();
			LibraryManageView libraryManageView=new LibraryManageView();
			
			if(role.equals("admin")) {
				libraryManageView.loginAsAdmin(input);
			}else if(role.equals("user")) {
				libraryManageView.loginAsUser(input);
			}else {
				System.out.println("Invalid Role.Please Try again..");
			}
		}
	}
}