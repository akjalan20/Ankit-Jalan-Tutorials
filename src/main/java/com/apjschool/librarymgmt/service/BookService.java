package com.apjschool.librarymgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apjschool.librarymgmt.controller.ServiceResponse;
import com.apjschool.librarymgmt.dao.BookDaoImpl;
import com.apjschool.librarymgmt.dao.BookIssuedDaoImpl;
import com.apjschool.librarymgmt.dao.entity.Book;
import com.apjschool.librarymgmt.dao.entity.BookIssued;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.BookIssuedDTO;
import com.apjschool.librarymgmt.dto.BookSearchDTO;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.mapper.EntityDtoMapper;

@Service("bookService")
@Transactional
public class BookService {

	@Autowired
	private BookIssuedDaoImpl bookIssuedDaoImpl;

	@Autowired
	private BookDaoImpl bookDaoImpl;

	private static final Logger logger = LogManager.getLogger(BookService.class);

	private EntityDtoMapper mapper = new EntityDtoMapper();

	public ServiceResponse<BookDTO> addBook(BookDTO bookDTO) {
		ServiceResponse<BookDTO> response = new ServiceResponse<>();

		try {
			Book bookEntity = mapper.populateBookEntity(bookDTO);
			bookDaoImpl.addBook(bookEntity);
			response.setResult(bookDTO);
		} catch (HibernateException e) {
			logger.error("HibernateException while adding Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("HibernateException while adding Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while adding Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("Exception while adding Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> updateBook(BookDTO bookDTO) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			Book bookEntity = mapper.populateBookEntity(bookDTO);
			bookDaoImpl.updateBook(bookEntity);
		} catch (HibernateException e) {
			logger.error("Exception while updating Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("Exception while updating Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while updating Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("Exception while updating Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> deleteBook(BookDTO bookDTO) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			Book bookEntity = mapper.populateBookEntity(bookDTO);
			bookDaoImpl.deleteBook(bookEntity);
		} catch (HibernateException e) {
			logger.error("Exception while deleting Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("Exception while deleting Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while deleting Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
			response.addError("Exception while deleting Book ISDN " + bookDTO.getBookIsdn() + " " + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<List<BookDTO>> searchBook(SearchFilterRequest searchFilter) {
		ServiceResponse<List<BookDTO>> response = new ServiceResponse<>();
		List<Book> bookEntityList = new ArrayList<>();
		try {
			if(searchFilter.getSearchFilter()!= null && searchFilter.getSearchFilter().size()>0){
				bookEntityList = bookDaoImpl.searchBook(searchFilter);				
			} else {
				bookEntityList = bookDaoImpl.getAllBooks();	
			}
			List<BookDTO> bookDtoList = mapper.populateBookDTOList(bookEntityList);
			response.setResult(bookDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public ServiceResponse<BookDTO> getBookById(Integer id) {
		ServiceResponse<BookDTO> response = new ServiceResponse<>();
		BookDTO bookDTO = null;
		try {
			Book bookEntity = bookDaoImpl.getBookById(id);
			bookDTO = mapper.populateBookDTO(bookEntity);
			if(bookDTO!=null) {
				response.setResult(bookDTO);
			} else {
				response.addError("Requested book with Id " + id + " not found.");
			}			
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<List<BookDTO>> getAllBooks() {
		ServiceResponse<List<BookDTO>> response = new ServiceResponse<>();
		try {
			List<Book> bookEntityList = bookDaoImpl.getAllBooks();
			List<BookDTO> bookDtoList = mapper.populateBookDTOList(bookEntityList);
			response.setResult(bookDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		}
		return response;
	}

	public ServiceResponse<Void> issueBook(BookIssuedDTO bookIssuedDto) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			BookDTO bookDto = bookIssuedDto.getBook();
			BookIssued bookIssued = new BookIssued();
			if (bookDto.getNoOfCopies() > bookDto.getNoOfCopyIssued()) {
				bookIssuedDaoImpl.saveEntity(bookIssued);
				bookIssued.getBook().setNoOfCopyIssued(bookIssued.getBook().getNoOfCopyIssued() + 1);
				bookDaoImpl.updateEntity(bookIssued.getBook());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public ServiceResponse<Void> returnBook(BookIssuedDTO bookIssuedDto) {
		ServiceResponse<Void> response = new ServiceResponse<>();
		try {
			BookDTO bookDto = bookIssuedDto.getBook();
			BookIssued bookIssued = new BookIssued();
			bookIssued.setReturnedDate(new Date());
			bookIssuedDaoImpl.updateEntity(bookIssued);
			if (bookIssued.getBook() != null) {
				bookIssued.getBook().setNoOfCopyIssued(bookIssued.getBook().getNoOfCopyIssued() - 1);
				bookDaoImpl.updateEntity(bookIssued.getBook());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public ServiceResponse<List<BookDTO>> searchBook(BookSearchDTO searchDTO) {
		ServiceResponse<List<BookDTO>> response = new ServiceResponse<>();
		List<Book> bookEntityList = new ArrayList<>();
		try {
			if(searchDTO!= null){
				bookEntityList = bookDaoImpl.searchBook(searchDTO);				
			} else {
				bookEntityList = bookDaoImpl.getAllBooks();	
			}
			List<BookDTO> bookDtoList = mapper.populateBookDTOList(bookEntityList);
			response.setResult(bookDtoList);
		} catch (HibernateException e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception while searching Book" + e.getMessage());
			response.addError("Exception while searching Book" + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
}
