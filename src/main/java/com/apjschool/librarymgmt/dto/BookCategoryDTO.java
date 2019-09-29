package com.apjschool.librarymgmt.dto;

public class BookCategoryDTO {

	private Integer bookCategoryId;
	private String categoryDesc;
	
	public BookCategoryDTO(){
		
	}
	
	public BookCategoryDTO(String categoryDesc) {
		super();
		this.categoryDesc = categoryDesc;
	}

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}
	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

}
