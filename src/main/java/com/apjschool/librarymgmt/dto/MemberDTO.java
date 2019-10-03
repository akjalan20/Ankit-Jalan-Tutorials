package com.apjschool.librarymgmt.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.apjschool.librarymgmt.util.IsValidHobby;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*@JsonPropertyOrder is used to specify the order in which the properties should appear in json response*/
//@JsonPropertyOrder({"First_Name","gender","firstName"})
@JsonIgnoreProperties({"deleteFlag"}) // to exclude properties in json response
@JsonInclude(JsonInclude.Include.NON_NULL) // to exclude null properties in json response
public class MemberDTO {

	private Integer memberId;
	private Integer registrationNo;
	/*@JsonProperty is used to change the key name that would appear in Json response*/
	@JsonProperty(value="First_Name")
	private String firstName;
	private String lastName;
	private String gender;
	private String hobby;
	private Long phoneNo;
	private Date dateofBirth;
	private String identificationType;
	private String identificationNo;
	
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

	@Size(min=2, max=5)
	@NotEmpty(message = "First name is compulsory")
	@Pattern(regexp = "[a-z-A-Z]*")
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

	@Past
	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@IsValidHobby(listValidHobbies="Music|Sports|Travel", message="Please provide a valid hobby; accepted hobbies are Music, Sports, Travel.")
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
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
