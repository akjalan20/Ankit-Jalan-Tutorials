package com.apjschool.librarymgmt.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "BOOK_ISSUED")
@AssociationOverrides({
		@AssociationOverride(name = "bookIssuedId.member", joinColumns = @JoinColumn(name = "MEMBER_ID")),
		@AssociationOverride(name = "bookIssuedId.book", joinColumns = @JoinColumn(name = "BOOK_ID")) })
public class BookIssued implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private BookIssuedId bookIssuedId = new BookIssuedId();
	private Date issuedDate = new Date();
	private Date dueDate = new Date();	
	private Date returnedDate = new Date();	
	private String lostFlag;
	
	public BookIssued() {

	}

	@EmbeddedId
	public BookIssuedId getBookIssuedId() {
		return bookIssuedId;
	}

	public void setBookIssuedId(BookIssuedId bookIssuedId) {
		this.bookIssuedId = bookIssuedId;
	}

	@Column(name = "ISSUE_DATE")
	@Temporal(TemporalType.DATE)
	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	@Column(name = "DUE_DATE")
	@Temporal(TemporalType.DATE)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "RETURN_DATE")
	@Temporal(TemporalType.DATE)
	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	@Column(name = "LOST_FG")
	public String getLostFlag() {
		return lostFlag;
	}

	public void setLostFlag(String lostFlag) {
		this.lostFlag = lostFlag;
	}
	
	@Transient
	public Member getMember() {
		return this.getBookIssuedId().getMember();
	}
	public void setMember(Member member) {
		this.getBookIssuedId().setMember(member);
	}
	@Transient
	public Book getBook() {
		return this.getBookIssuedId().getBook();
	}
	public void setBook(Book book) {
		this.getBookIssuedId().setBook(book);
	}

	@Override
	public int hashCode() {
		return (getBookIssuedId() != null ? getBookIssuedId().hashCode() : 0);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BookIssued that = (BookIssued) o;

		if (getBookIssuedId() != null ? !getBookIssuedId().equals(that.getBookIssuedId())
				: that.getBookIssuedId() != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "BookIssued [bookIssuedId=" + bookIssuedId + ", issuedDate=" + issuedDate + ", dueDate=" + dueDate
				+ ", returnedDate=" + returnedDate + ", lostFlag=" + lostFlag + "]";
	}
	
	

}
