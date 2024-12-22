package com.kannanrameshrk.dto;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String userName;
	private List<Book> borrowedBooks;
	
	public Member(String userName) {
		this.userName=userName;
		this.borrowedBooks=new ArrayList<>();	
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	
	public boolean borrowBook(Book book) {
		if(borrowedBooks.size()<5 && book.isAvailable()) {
			borrowedBooks.add(book);
			book.setAvailable(false);
			return true;
		}
		return false;
	}
	
	public void returnBook(Book book) {
		borrowedBooks.remove(book);
		book.setAvailable(true);
	}
}
