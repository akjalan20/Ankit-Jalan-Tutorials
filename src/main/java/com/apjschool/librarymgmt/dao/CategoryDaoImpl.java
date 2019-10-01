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

import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookCategory;;

@Repository("CategoryDaoImpl")
public class CategoryDaoImpl extends GenericDao<BookCategory> implements CategoryDao {

	public void addBookCategory(BookCategory bookCategory) {
		saveEntity(bookCategory);
	}

	public void updateBookCategory(BookCategory bookCategory) {
		updateEntity(bookCategory);
	}

	public void deleteBookCategory(BookCategory bookCategory) {
		try {
			deleteEntity(bookCategory);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BookCategory> getAllBookCategorys() {
		List<BookCategory> bookCategorys = new ArrayList<>(0);
		bookCategorys = getEntity(BookCategory.class);
		return bookCategorys;
	}

	public BookCategory getBookCategoryById(Integer id) {
		BookCategory bookCategory = getById(BookCategory.class, id);
		System.out.println(bookCategory);
		return bookCategory;
	}

	public List<BookCategory> searchBookCategory(BookCategory bookCategory) {
		Session session = getSession();
		List<BookCategory> bookCategorys = new ArrayList<BookCategory>();

		Criteria criteria = session.createCriteria(BookCategory.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		if (bookCategory != null && bookCategory.getCategoryDesc().isEmpty()) {
			if (bookCategory.getCategoryDesc() != null && !bookCategory.getCategoryDesc().isEmpty()) {
				criterion = Restrictions.ilike("categoryDesc", bookCategory.getCategoryDesc(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}

		}
		/*
		 * setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) removes suplicate records
		 */
		criteria.add(conjunction).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		bookCategorys = criteria.list();
		return bookCategorys;
	}

}
