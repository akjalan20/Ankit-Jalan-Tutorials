package com.apjschool.librarymgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apjschool.librarymgmt.controller.ServiceResponse;
import com.apjschool.librarymgmt.dao.AuthorDaoImpl;
import com.apjschool.librarymgmt.dao.CategoryDaoImpl;
import com.apjschool.librarymgmt.dao.LanguageDaoImpl;
import com.apjschool.librarymgmt.dao.PublisherDaoImpl;
import com.apjschool.librarymgmt.dao.entity.Author;
import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookCategory;
import com.apjschool.librarymgmt.dao.entity.Language;
import com.apjschool.librarymgmt.dao.entity.Publisher;
import com.apjschool.librarymgmt.dto.AuthorDTO;
import com.apjschool.librarymgmt.dto.BookCategoryDTO;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.LanguageDTO;
import com.apjschool.librarymgmt.dto.PublisherDTO;
import com.apjschool.librarymgmt.mapper.EntityDtoMapper;

@Service("miscService")
@Transactional
public class MiscService {

	@Autowired
	private AuthorDaoImpl authorDaoImpl;

	@Autowired
	private CategoryDaoImpl categoryDaoImpl;

	@Autowired
	private PublisherDaoImpl publisherDaoImpl;

	@Autowired
	private LanguageDaoImpl languageDaoImpl;

	private static final Logger logger = LogManager.getLogger(BookService.class);

	private EntityDtoMapper mapper = new EntityDtoMapper();

	public void saveAuthor(Author author) {
		try {
			authorDaoImpl.saveEntity(author);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAuthor(Author author) {
		try {
			authorDaoImpl.updateEntity(author);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAuthor(Author author) {
		try {
			authorDaoImpl.deleteEntity(author);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceResponse<List<AuthorDTO>> getAuthor() {
		ServiceResponse<List<AuthorDTO>> response = new ServiceResponse<>();
		List<Author> authors = new ArrayList<>();	
		try {
			authors = authorDaoImpl.getEntity(Author.class);
			List<AuthorDTO> authorDtoList = mapper.populateAuthorDTOList(authors);
			response.setResult(authorDtoList);
		} catch (HibernateException e) {
			logger.error("HibernateException while searching Author" + e.getMessage());
			response.addError("HibernateException while searching Author" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Author" + e.getMessage());
			response.addError("Exception while searching Author" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public void saveBookCategory(BookCategory category) {
		try {
			categoryDaoImpl.saveEntity(category);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBookCategory(BookCategory category) {
		try {
			categoryDaoImpl.updateEntity(category);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBookCategory(BookCategory category) {
		try {
			categoryDaoImpl.deleteEntity(category);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceResponse<List<BookCategoryDTO>> getBookCategory() {
		ServiceResponse<List<BookCategoryDTO>> response = new ServiceResponse<>();
		List<BookCategory> categories = new ArrayList<>();	
		try {
			categories = categoryDaoImpl.getEntity(BookCategory.class);
			List<BookCategoryDTO> categoryDtoList = mapper.populateCategoryDTOList(categories);
			response.setResult(categoryDtoList);
		} catch (HibernateException e) {
			logger.error("HibernateException while searching BookCategory" + e.getMessage());
			response.addError("HibernateException while searching BookCategory" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching BookCategory" + e.getMessage());
			response.addError("Exception while searching BookCategory" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public void savePublisher(Publisher publisher) {
		try {
			publisherDaoImpl.saveEntity(publisher);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePublisher(Publisher publisher) {
		try {
			publisherDaoImpl.updateEntity(publisher);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePublisher(Publisher publisher) {
		try {
			publisherDaoImpl.deleteEntity(publisher);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceResponse<List<PublisherDTO>> getPublishers() {
		ServiceResponse<List<PublisherDTO>> response = new ServiceResponse<>();
		List<Publisher> publisherList = new ArrayList<>();	
		try {
			publisherList = publisherDaoImpl.getEntity(Publisher.class);
			List<PublisherDTO> publisherDtoList = mapper.populatePublisherDTOList(publisherList);
			response.setResult(publisherDtoList);
		} catch (HibernateException e) {
			logger.error("HibernateException while searching Publisher" + e.getMessage());
			response.addError("HibernateException while searching Publisher" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Publisher" + e.getMessage());
			response.addError("Exception while searching Publisher" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public void saveLanguage(Language language) {
		try {
			languageDaoImpl.saveEntity(language);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLanguage(Language language) {
		try {
			languageDaoImpl.updateEntity(language);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteLanguage(Language language) {
		try {
			languageDaoImpl.deleteEntity(language);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceResponse<List<LanguageDTO>> getlanguages() {
		ServiceResponse<List<LanguageDTO>> response = new ServiceResponse<>();
		List<Language> languageList = new ArrayList<>();	
		try {
			languageList = languageDaoImpl.getEntity(Language.class);
			List<LanguageDTO> languageDtoList = mapper.populateLanguageDTOList(languageList);
			response.setResult(languageDtoList);
		} catch (HibernateException e) {
			logger.error("HibernateException while searching Publisher" + e.getMessage());
			response.addError("HibernateException while searching Publisher" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Publisher" + e.getMessage());
			response.addError("Exception while searching Publisher" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
}
