package com.apjschool.librarymgmt.dao.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "BOOK", uniqueConstraints = @UniqueConstraint(columnNames = { "BOOK_ISDN" }))
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private String bookName;
	private String bookIsdn;
	private Double price;
	private Integer publishYear;
	private Integer pages;
	private Integer noOfCopies;
	private Integer noOfCopyIssued;

	private Set<Author> authors = new HashSet<>();
	private BookCategory category;
	private Publisher publisher;
	private Language language;
	/*private Set<BookIssued> bookIssued = new HashSet<>();*/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "BOOK_NAME")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "BOOK_ISDN")
	public String getBookIsdn() {
		return bookIsdn;
	}

	public void setBookIsdn(String bookIsdn) {
		this.bookIsdn = bookIsdn;
	}

	@Column(name = "BOOK_PRICE")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "PUBLISH_YEAR")
	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	@Column(name = "NO_OF_PAGES")
	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Column(name = "NO_OF_COPIES")
	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@ManyToMany(cascade = { CascadeType.ALL, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "BOOK_AUTHOR", uniqueConstraints = @UniqueConstraint(columnNames = { "BOOK_ID",
			"AUTHOR_ID" }), joinColumns = {
					@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
							@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false) })
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PUBLISHER_ID")
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LANGUAGE_ID")
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	/*@OneToMany(mappedBy = "bookIssuedId.book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<BookIssued> getBookIssued() {
		return bookIssued;
	}

	public void setBookIssued(Set<BookIssued> bookIssued) {
		this.bookIssued = bookIssued;
	}*/

	@Column(name = "COPIES_ISSUED")
	public Integer getNoOfCopyIssued() {
		return noOfCopyIssued;
	}

	public void setNoOfCopyIssued(Integer noOfCopyIssued) {
		this.noOfCopyIssued = noOfCopyIssued;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	/*
	 * @Override public String toString() { return "Book [bookId=" + bookId +
	 * ", bookName=" + bookName + ", bookIsdn=" + bookIsdn + ", price=" + price
	 * + ", publishYear=" + publishYear + ", pages=" + pages + ", noOfCopies=" +
	 * noOfCopies + ", authors=" + authors + ", categories=" + categories +
	 * ", publisher=" + publisher + ", language=" + language + ", bookIssued=" +
	 * bookIssued + "]"; }
	 */

}
