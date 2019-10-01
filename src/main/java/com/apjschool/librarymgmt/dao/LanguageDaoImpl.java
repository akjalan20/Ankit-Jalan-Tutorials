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

import com.apjschool.librarymgmt.dao.entity.Language;

@Repository("LanguageDaoImpl")
public class LanguageDaoImpl extends GenericDao<Language> implements LanguageDao {

	public void addLanguage(Language language) {
		saveEntity(language);
	}

	public void updateLanguage(Language language) {
		updateEntity(language);
	}

	public void deleteLanguage(Language language) {
		try {
			deleteEntity(language);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Language> getAllLanguages() {
		List<Language> languages = new ArrayList<>(0);
		languages = getEntity(Language.class);
		return languages;
	}

	public Language getLanguageById(Integer id) {
		Language language = getById(Language.class, id);
		System.out.println(language);
		return language;
	}

	public List<Language> searchLanguage(Language language) {
		Session session = getSession();
		List<Language> languages = new ArrayList<Language>();

		Criteria criteria = session.createCriteria(Language.class);
		Conjunction conjunction = Restrictions.conjunction();
		Criterion criterion = null;

		if (language != null && language.getLanguageDesc().isEmpty()) {
			if (language.getLanguageDesc() != null && !language.getLanguageDesc().isEmpty()) {
				criterion = Restrictions.ilike("languageDesc", language.getLanguageDesc(), MatchMode.ANYWHERE);
				conjunction.add(criterion);
			}

		}
		/*
		 * setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) removes suplicate records
		 */
		criteria.add(conjunction).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		languages = criteria.list();
		return languages;
	}

}
