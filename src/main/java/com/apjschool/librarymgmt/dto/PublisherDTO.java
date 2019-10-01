package com.apjschool.librarymgmt.dto;

import java.util.ArrayList;
import java.util.List;

public class PublisherDTO {

	private Integer publisherId;
	private String publisherName;
	private String publisherPhoneNo;
	private String publisherEmail;

	private List<BookDTO> bookDTOs = new ArrayList<>();
	private AddressDTO publisherAddress;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherPhoneNo() {
		return publisherPhoneNo;
	}

	public void setPublisherPhoneNo(String publisherPhoneNo) {
		this.publisherPhoneNo = publisherPhoneNo;
	}

	public String getPublisherEmail() {
		return publisherEmail;
	}

	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}

	public List<BookDTO> getBooks() {
		return bookDTOs;
	}

	public void setBooks(List<BookDTO> bookDTOs) {
		this.bookDTOs = bookDTOs;
	}

	public AddressDTO getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(AddressDTO publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

}
