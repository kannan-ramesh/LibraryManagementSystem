package com.kannanrameshrk.repository;

import java.util.ArrayList;
import java.util.List;

import com.kannanrameshrk.dto.Book;
import com.kannanrameshrk.dto.Member;

public class Repository {
	public static Repository repository;
	public List<Book> books=new ArrayList<>();
	public List<Member> members=new ArrayList<>();
	public static final String ADMINUSERNAME="admin";
	public static final String PASSWORD="password";
	
	
	private Repository() {
		
	}
	
	public static Repository getInstance() {
		if(repository==null) {
			return repository = new Repository();
		}
		return repository;
		
	}

	public void add() {
		books.add(new Book("Science","John Doe","Education"));
		books.add(new Book("Social Studies","jane Smith","Education"));
	}

	public List<com.kannanrameshrk.dto.Member> getMember() {
		// TODO Auto-generated method stub
		return members;
	}

	public List<Book> getBook() {
		 return books;
	}
}
