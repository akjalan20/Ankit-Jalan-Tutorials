package com.apjschool.librarymgmt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dao.entity.Member;
import com.apjschool.librarymgmt.dto.SearchFilter;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;

@Repository("bookDaoImpl")
public class BookDaoImpl extends GenericDao<Book> implements BookDao {

	public void addBook(Book book) {
		saveEntity(book);
	}

	public void updateBook(Book book) {
		updateEntity(book);
	}

	public void deleteBook(Book book) {
		try {
			deleteEntity(book);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>(0);
		books = getEntity(Book.class);
		return books;
	}

	public Book getBookById(Integer id) {
		Book book = getById(Book.class, id);
		System.out.println(book);
		return book;
	}

	public List<Book> searchBook(SearchFilterRequest searchFilter) {
		Session session = getSession();
		List<Book> books = new ArrayList<>();

		Criteria criteria = session.createCriteria(Book.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		for (SearchFilter filter : searchFilter.getSearchFilter()) {
			switch (filter.getName().trim()) {
			case "bookIsdn":
				criterion = Restrictions.eq("bookIsdn", filter.getValue());
				break;
			case "bookName":
				criterion = Restrictions.ilike("bookName", filter.getValue(), MatchMode.ANYWHERE);
				break;
			case "author":
				criterion = Restrictions.eq("authors.authorId", filter.getValue());
				break;
			case "category":
				criterion = Restrictions.ilike("categories.bookCategoryId", filter.getValue(), MatchMode.ANYWHERE);
				break;
			case "publisher":
				criterion = Restrictions.eq("publisher.publisherId", filter.getValue());
				break;
			/*
			 * default: criterion = Restrictions.ne("deleteFlag", "Y"); break;
			 */
			}
			conjunction.add(criterion);
		}

		criteria.add(conjunction);

		books = criteria.list();

		/*
		 * ScrollableResults iterator = criteria.setFirstResult(maxRowsPerFetch
		 * * rowIndex) .setMaxResults(maxRowsPerFetch)
		 * .scroll(ScrollMode.FORWARD_ONLY);
		 */

		return books;
	}

	public Session getSession() {
		HibernateTemplate template = getTemplate();
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

}
