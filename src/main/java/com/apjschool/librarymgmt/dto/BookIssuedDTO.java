package com.apjschool.librarymgmt.dto;

import java.util.Date;

public class BookIssuedDTO {

	private MemberDTO memberDTO;
	private BookDTO bookDTO;
	private Date issuedDate;
	private Date dueDate;	
	private Date returnedDate;	
	private String lostFlag;
	
	public MemberDTO getMember() {
		return memberDTO;
	}
	public void setMember(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public BookDTO getBook() {
		return bookDTO;
	}
	public void setBook(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public String getLostFlag() {
		return lostFlag;
	}
	public void setLostFlag(String lostFlag) {
		this.lostFlag = lostFlag;
	}
	
}
