package com.apjschool.librarymgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class GenericDao<T> {

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private SessionFactory factory;

	public void saveEntity(T obj) {
		template.save(obj);
	}

	public void updateEntity(T obj) {
		template.update(obj);
		template.flush();
	}

	public void deleteEntity(T obj) {
		template.delete(obj);
		template.flush();
	}

	public T getById(Class<T> classObj, int id) {
		return template.get(classObj, id);
	}

	public List<T> getEntity(Class<T> classObj) {
		//return template.loadAll(classObj);
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(classObj);
		//criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
		
	}
	
	

	public HibernateTemplate getTemplate() {
		return template;
	}
	
	public Session getSession() {
		HibernateTemplate template = getTemplate();
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

}
