package com.apjschool.librarymgmt.dto;

public class LanguageDTO {

	private Integer languageId;
	private String languageDesc;
	
	public LanguageDTO(){}
	
	public LanguageDTO(String languageDesc) {
		super();
		this.languageDesc = languageDesc;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

}
