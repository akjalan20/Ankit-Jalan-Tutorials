package com.apjschool.librarymgmt.dao.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class BookIssuedId implements Serializable{
	
	private Member member;
	private Book book;
	
	@ManyToOne
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@ManyToOne
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public int hashCode() {
		int result;
        result = (book != null ? book.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
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
		BookIssuedId other = (BookIssuedId) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookIssuedId [member=" + member + ", book=" + book + "]";
	}

	


}
