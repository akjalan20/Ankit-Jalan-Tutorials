package com.apjschool.librarymgmt.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PUBLISHER", uniqueConstraints = @UniqueConstraint(columnNames = { "PUBLISHER_NAME" }))
public class Publisher {

	private Integer publisherId;
	private String PublisherName;
	private String publisherPhoneNo;
	private String publisherEmail;

	private List<Book> books = new ArrayList<>();
	private Address publisherAddress;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PUBLISHER_ID")
	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	@Column(name = "PUBLISHER_NAME")
	public String getPublisherName() {
		return PublisherName;
	}

	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}
	@Column(name = "PHONE_NO")
	public String getPublisherPhoneNo() {
		return publisherPhoneNo;
	}

	public void setPublisherPhoneNo(String publisherPhoneNo) {
		this.publisherPhoneNo = publisherPhoneNo;
	}
	@Column(name = "EMAIL")
	public String getPublisherEmail() {
		return publisherEmail;
	}

	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(Address publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisherId == null) ? 0 : publisherId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (publisherId == null) {
			if (other.publisherId != null)
				return false;
		} else if (!publisherId.equals(other.publisherId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", PublisherName=" + PublisherName + ", publisherPhoneNo="
				+ publisherPhoneNo + ", publisherEmail=" + publisherEmail + ", books=" + books + ", publisherAddress="
				+ publisherAddress + "]";
	}



}
