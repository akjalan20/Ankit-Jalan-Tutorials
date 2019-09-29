package com.apjschool.librarymgmt.dao;

import org.springframework.stereotype.Repository;

import com.apjschool.librarymgmt.dao.entity.BookIssued;

@Repository("BookIssuedDaoImpl")
public class BookIssuedDaoImpl extends GenericDao<BookIssued> implements BookIssuedDao {

	
	public void issueBook(){};
	public void returnBook(){};

}
