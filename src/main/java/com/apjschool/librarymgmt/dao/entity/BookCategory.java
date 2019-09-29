package com.apjschool.librarymgmt.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CATEGORY", uniqueConstraints = @UniqueConstraint(columnNames = { "CATEGORY_DESC" }))
public class BookCategory {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")*/
	private Integer bookCategoryId;
	//@Column(name = "CATEGORY_DESC")
	private String categoryDesc;

	public BookCategory() {

	}

	public BookCategory(String categoryDesc) {
		super();
		this.categoryDesc = categoryDesc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	@Column(name = "CATEGORY_DESC")
	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCategoryId;
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
		BookCategory other = (BookCategory) obj;
		if (bookCategoryId != other.bookCategoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookCategory [bookCategoryId=" + bookCategoryId + ", categoryDesc=" + categoryDesc + "]";
	}

}
