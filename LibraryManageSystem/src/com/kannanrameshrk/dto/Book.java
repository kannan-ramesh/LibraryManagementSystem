package com.kannanrameshrk.dto;

public class Book {
	private String title;
	private String author;
	private String genre;
	private boolean isAvailable=true;
	
	public Book(String title,String author,String genre) {
		this.title=title;
		this.author=author;
		this.genre=genre;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
