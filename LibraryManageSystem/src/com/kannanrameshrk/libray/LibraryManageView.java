package com.kannanrameshrk.libray;

import java.util.List;
import java.util.Scanner;

import com.kannanrameshrk.dto.Book;
import com.kannanrameshrk.dto.Member;
import com.kannanrameshrk.repository.Repository;

public class LibraryManageView {
	public LibraryManageViewModel libraryManageViewModel;
	Member loggedInMember=null;
	
	public LibraryManageView() {
		libraryManageViewModel = new LibraryManageViewModel(this);
	}

	public void loginAsAdmin(Scanner input) {
		System.out.println("\t\t Home Menu");
		System.out.println("\t\t**********************");
		
		System.out.println("Enter User Name:");
		String userName=input.nextLine();
		System.out.println("Enter Password:");
		String password=input.nextLine();
		
		if(libraryManageViewModel.checkIsAdmin(userName,password)) {
			onMessage("Logged in as admin");
			adminMenu(input);
		}else {
			onMessage("Invalid admin credentials");
		}
		
	}
	
	private void adminMenu(Scanner input) {
		while(true) {
			System.out.println("\t\t Admin Menu");
			System.out.println("\t\t**********************");
			System.out.println(" 1.Add Book");
			System.out.println(" 2.Update Book");
			System.out.println(" 3.Remove Book");
			System.out.println(" 4.Add Member");
			System.out.println(" 5.Display All Books");
			System.out.println(" 6.Display All Members");
			System.out.println(" 7.Exit");
			
			System.out.println("Enter your choice:");
			int choice=input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:{
				addBook(input);
				break;
			}
			case 2:{
				updateBook(input);
				break;
			}
			case 3:{
				removeBook(input);
				break;
			}
			case 4:{
				addMember(input);
				break;
			}
			case 5:{
				displayAllBooks();
				break;
			}
			case 6:{
				displayAllMembers();
				break;
			}
			case 7:{
				return;
			}
			default:{
				onMessage("Invalid choice.Please Try Again..");
				break;
			}
			}
			
		}
	}

	private void displayAllMembers() {
		System.out.println("\t\t Memers");
		System.out.println("\t\t**********");
		List<Member> arr=Repository.getInstance().members;
		
		
		System.out.println("Name");
		System.out.println("************");
		
		for(Member member:arr) {
			System.out.println(member.getUserName());
		}
	}

	private void displayAllBooks() {
		System.out.println("\t\t Books");
		System.out.println("\t\t**********");
		
		List<Book> arr=Repository.getInstance().books;
		System.out.println("Title    Author      Genre       Available");
		System.out.println("--------------------------------------------");
		
		for(Book books:arr) {
			System.out.println(books.getTitle()+"   "+books.getAuthor() +"  "+books.getGenre()+"     "+books.isAvailable());
		}
	}

	private void addMember(Scanner input) {
		System.out.println("Enter User Name");
		String userName=input.nextLine();
		
		Member member=new Member(userName);
		libraryManageViewModel.addMember(member);
		onMessage("Member added Success");
		
	}

	private void removeBook(Scanner input) {
		System.out.println("Enter Book Title:");
		String title=input.nextLine();
		
		if(libraryManageViewModel.removeBook(title)) {
			onMessage("Book Removed Successfully");
		}else {
			onMessage("Book Not Found..");
		}
	}

	private void updateBook(Scanner input) {
		System.out.println("Enter Book Title:");
		String title=input.nextLine();
		
		Book book=libraryManageViewModel.findBook(title);
		
		if(book!=null) {
			System.out.println("Enter new Authoe:");
			book.setAuthor(input.nextLine());
			System.out.println("Enter new Genre:");
			book.setGenre(input.nextLine());
			onMessage("Book Updated Successfully");
		}else {
			onMessage("Book Not Bound");
		}
	}

	private void addBook(Scanner input) {
		System.out.println("Enter Book Title:");
		String title=input.nextLine();
		System.out.println("Enter Book Author:");
		String author=input.nextLine();
		System.out.println("Enter book Genre:");
		String genre=input.nextLine();
		
		Book book=new Book(title,author,genre);
		libraryManageViewModel.addBook(book);
		onMessage("Book Added SuccessFully");
		
	}

	public void loginAsUser(Scanner input) {
		System.out.println("Enter User Name:");
		String userName=input.nextLine();
		loggedInMember = libraryManageViewModel.findCreateMember(userName);
		onMessage("Logged in as User. ");
		userMenu(input);
	}
	
	private void userMenu(Scanner input) {
		while(true) {
			System.out.println("\t\t User Menu");
			System.out.println("\t\t**********************");
			System.out.println(" 1. Borrow Book\n 2.Return Book\n 3.Display All Books\n 4.Display All Members\n 5.Exit ");
			System.out.println("Enter Your Choice:");
			int choice=input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:{
				borrowBook(input);
				break;
			}case 2:{
				returnBook(input);
				break;
			}case 3:{
				displayAllBooks();
				break;
			}case 4:{
				displayAllMembers();
				break;
			}case 5:{
				return;
			}
			default:{
				onMessage("Invalid choice.Please Try Again");
				break;
			}
			}
		}
	}

	private void returnBook(Scanner input) {
		System.out.println("Enter book Title:");
		String title=input.nextLine();
		
		Book book=libraryManageViewModel.findBook(title);
		
		if(book!=null && !book.isAvailable()) {
			loggedInMember.returnBook(book);
			onMessage("Book returned Successfully");
		}else{
			onMessage("Books is Not found");
		}
	}

	private void borrowBook(Scanner input) {
		System.out.println("Enter book Title:");
		String title=input.nextLine();
		
		Book book=libraryManageViewModel.findBook(title);
		
		if(book!=null && loggedInMember.borrowBook(book)) {
			onMessage("Book Borrowed Successfully.");
		}else {
			onMessage("Book is either unavailable or borrow limit reached.");
		}
	}

	public void onMessage(String message) {
		System.out.println(message);
	}
}