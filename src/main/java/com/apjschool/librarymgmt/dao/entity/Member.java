package com.apjschool.librarymgmt.dao.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.apjschool.librarymgmt.util.IsValidHobby;

@Entity
@Table(name="MEMBER")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	private Address address;
	private Set<BookIssued> bookIssued = new HashSet<>(0);
	
	 
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "bookIssuedId.member")
	public Set<BookIssued> getBookIssued() {
		return bookIssued;
	}

	public void setBookIssued(Set<BookIssued> bookIssued) {
		this.bookIssued = bookIssued;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID", unique = true, nullable = false)
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "REGISTRATION_NO")
	public Integer getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Integer registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Column(name = "FIRST_NAME")
	@Size(min=2, max=5)
	@NotEmpty(message = "First name is compulsory")
	@Pattern(regexp = "[a-z-A-Z]*")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "HOBBY")
	@IsValidHobby(listValidHobbies="Music|Sports|Travel", message="Please provide a valid hobby; accepted hobbies are Music, Sports, Travel.")
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Column(name = "PHONE_NO")
	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "BIRTH_DATE")
	@Past
	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Column(name = "ID_TYPE")
	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	@Column(name = "ID_NUMBER")
	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Column(name = "DELETE_FLAG")
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/*@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", registrationNo=" + registrationNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", Semester=" + Semester + ", phoneNo=" + phoneNo
				+ ", dateofBirth=" + dateofBirth + ", identificationType=" + identificationType + ", identificationNo="
				+ identificationNo + ", deleteFlag=" + deleteFlag + ", address=" + address + ", bookIssued="
				+ bookIssued + "]";
	}*/

	
	

}
