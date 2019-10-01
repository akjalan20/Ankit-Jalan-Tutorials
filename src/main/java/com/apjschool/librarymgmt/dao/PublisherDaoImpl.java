package com.apjschool.librarymgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.apjschool.librarymgmt.dao.entity.Publisher;
import com.apjschool.librarymgmt.dao.entity.Publisher;

@Repository("PublisherDaoImpl")
public class PublisherDaoImpl extends GenericDao<Publisher> implements PublisherDao {

	public void addPublisher(Publisher publisher) {
		saveEntity(publisher);
	}

	public void updatePublisher(Publisher publisher) {
		updateEntity(publisher);
	}

	public void deletePublisher(Publisher publisher) {
		try {
			deleteEntity(publisher);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Publisher> getAllPublishers() {
		List<Publisher> publishers = new ArrayList<>(0);
		publishers = getEntity(Publisher.class);
		return publishers;
	}

	public Publisher getPublisherById(Integer id) {
		Publisher publisher = getById(Publisher.class, id);
		System.out.println(publisher);
		return publisher;
	}

	public List<Publisher> searchPublisher(Publisher publisher) {
		Session session = getSession();
		List<Publisher> publishers = new ArrayList<Publisher>();

		Criteria criteria = session.createCriteria(Publisher.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		if (publisher != null && publisher.getPublisherName().isEmpty()) {
			if (publisher.getPublisherName() != null && !publisher.getPublisherName().isEmpty()) {
				criterion = Restrictions.ilike("publisherName", publisher.getPublisherName(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}
			if (publisher.getPublisherPhoneNo() != null && !publisher.getPublisherPhoneNo().isEmpty()) {
				criterion = Restrictions.eq("publisherPhoneNo", publisher.getPublisherPhoneNo());
				conjunction.add(criterion);
			}
			if (publisher.getPublisherEmail() != null && !publisher.getPublisherEmail().isEmpty()) {
				criterion = Restrictions.ilike("publisherEmail", publisher.getPublisherEmail(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}
		}
		/*
		 * setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) removes suplicate records
		 */
		criteria.add(conjunction).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		publishers = criteria.list();
		return publishers;
	}

}
