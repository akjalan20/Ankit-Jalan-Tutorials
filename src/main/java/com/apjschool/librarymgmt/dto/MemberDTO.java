package com.apjschool.librarymgmt.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MemberDTO {

	private Integer memberId;
	private Integer registrationNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String hobby;
	private Long phoneNo;
	private Date dateofBirth;
	private String identificationType;
	private String identificationNo;
	private String deleteFlag;

	private AddressDTO addressDTO;
	private Set<BookIssuedDTO> bookIssuedDTO = new HashSet<>(0);

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Integer registrationNo) {
		this.registrationNo = registrationNo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public AddressDTO getAddress() {
		return addressDTO;
	}

	public void setAddress(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public Set<BookIssuedDTO> getBookIssued() {
		return bookIssuedDTO;
	}

	public void setBookIssued(Set<BookIssuedDTO> bookIssuedDTO) {
		this.bookIssuedDTO = bookIssuedDTO;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}
