package com.kannanrameshrk.libray;

import java.util.List;

import com.kannanrameshrk.dto.Book;
import com.kannanrameshrk.dto.Member;
import com.kannanrameshrk.repository.Repository;

class LibraryManageViewModel {
	public LibraryManageView libraryManageView;

	public LibraryManageViewModel(LibraryManageView libraryManageView) {
		this.libraryManageView=libraryManageView;
	}

	public boolean checkIsAdmin(String userName, String password) {
		return Repository.ADMINUSERNAME.equals(userName) && Repository.PASSWORD.equals(password);
	}

	public Member findCreateMember(String userName) {
		List<Member> arr=Repository.getInstance().getMember();
		
		for(Member member:arr) {
			if(member.getUserName().equals(userName)) {
				return member;
			}
		}
		Member newMember=new Member(userName);
		Repository.getInstance().members.add(newMember);
		return newMember;
	}

	public void addBook(Book book) {
		Repository.getInstance().books.add(book);
	}

	public Book findBook(String title) {
		List<Book> arr=Repository.getInstance().getBook();
		
		for(Book book:arr) {
			if(book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	public boolean removeBook(String title) {
		List<Book> arr=Repository.getInstance().getBook();
		

		for(Book book:arr) {
			if(book.getTitle().equals(title)) {
				arr.remove(book);
				return true;
			}
		}
		return false;
	}

	public void addMember(Member member) {
		Repository.getInstance().members.add(member);
	}

}
