package com.apjschool.librarymgmt.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LANGUAGE", uniqueConstraints = @UniqueConstraint(columnNames = { "LANGUAGE_DESC" }))
public class Language {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID")*/
	private Integer languageId;
	/*@Column(name = "LANGUAGE_DESC")*/
	private String languageDesc;

	public Language() {

	}

	public Language(String languageDesc) {
		super();
		this.languageDesc = languageDesc;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID")
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	@Column(name = "LANGUAGE_DESC")
	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
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
		Language other = (Language) obj;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageDesc=" + languageDesc + "]";
	}

}
