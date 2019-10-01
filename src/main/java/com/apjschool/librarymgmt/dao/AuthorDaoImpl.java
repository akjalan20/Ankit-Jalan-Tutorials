package com.apjschool.librarymgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.apjschool.librarymgmt.dao.entity.Author;
import com.apjschool.librarymgmt.dao.entity.Book;

@Repository("authorDaoImpl")
public class AuthorDaoImpl extends GenericDao<Author> implements AuthorDao {

	public void addAuthor(Author author) {
		saveEntity(author);
	}

	public void updateAuthor(Author author) {
		updateEntity(author);
	}

	public void deleteAuthor(Author author) {
		try {
			deleteEntity(author);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<>(0);
		authors = getEntity(Author.class);
		return authors;
	}

	public Author getAuthorById(Integer id) {
		Author author = getById(Author.class, id);
		System.out.println(author);
		return author;
	}

	public List<Author> searchAuthor(Author author) {
		Session session = getSession();
		List<Author> authors = new ArrayList<Author>();

		Criteria criteria = session.createCriteria(Author.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;
		
		if(author != null && author.getFirstName().isEmpty()) {
			if(author.getFirstName()!=null && !author.getFirstName().isEmpty()) {
				criterion = Restrictions.ilike("firstName", author.getFirstName(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			} 
			if(author.getLastName()!=null && !author.getLastName().isEmpty()) {
				criterion = Restrictions.ilike("lastName", author.getLastName(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			} 
			if(author.getAuthorEmail()!=null && !author.getAuthorEmail().isEmpty()) {
				criterion = Restrictions.ilike("authorEmail", author.getAuthorEmail(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			} 
			
		}
		/*setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) removes suplicate records*/
		criteria.add(conjunction).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		authors = criteria.list();
		return authors;
	}
	
}
