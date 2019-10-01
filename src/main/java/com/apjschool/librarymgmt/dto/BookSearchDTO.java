package com.apjschool.librarymgmt.dto;

public class BookSearchDTO {

	private String bookIsdn;
	private String bookName;
	private String authorFirstName;
	private String categoryDesc;
	private String languageDesc;
	private String publisherName;
	
	public String getBookIsdn() {
		return bookIsdn;
	}
	public void setBookIsdn(String bookIsdn) {
		this.bookIsdn = bookIsdn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getLanguageDesc() {
		return languageDesc;
	}
	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	

}
