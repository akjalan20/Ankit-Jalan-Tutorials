package com.apjschool.librarymgmt.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


public class BookDTO implements BaseDTO{

	private Integer bookId;
	private String bookName;
	private String bookIsdn;
	private Double price;
	private Integer publishYear;
	private Integer pages;
	private Integer noOfCopies;
	private Integer noOfCopyIssued;

	private Set<AuthorDTO> authors = new HashSet<>();
	private BookCategoryDTO bookCategory;
	private PublisherDTO publisher;
	private LanguageDTO language;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookIsdn() {
		return bookIsdn;
	}

	public void setBookIsdn(String bookIsdn) {
		this.bookIsdn = bookIsdn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public Integer getNoOfCopyIssued() {
		return noOfCopyIssued;
	}

	public void setNoOfCopyIssued(Integer noOfCopyIssued) {
		this.noOfCopyIssued = noOfCopyIssued;
	}

	public Set<AuthorDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorDTO> authors) {
		this.authors = authors;
	}

	public BookCategoryDTO getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategoryDTO bookCategory) {
		this.bookCategory = bookCategory;
	}

	public PublisherDTO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDTO publisher) {
		this.publisher = publisher;
	}

	public LanguageDTO getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDTO language) {
		this.language = language;
	}

}
