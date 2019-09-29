package com.apjschool.librarymgmt.dto;

public class AuthorDTO {

	private Integer authorId;
	private String firstName;
	private String lastName;
	private String authorEmail;

	
	
	public AuthorDTO(String firstName, String lastName, String authorEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.authorEmail = authorEmail;
	}

	public AuthorDTO() {
		
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

}
