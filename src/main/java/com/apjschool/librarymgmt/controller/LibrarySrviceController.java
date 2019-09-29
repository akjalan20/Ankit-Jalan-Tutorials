package com.apjschool.librarymgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apjschool.librarymgmt.dto.AuthorDTO;
import com.apjschool.librarymgmt.dto.BaseResponse;
import com.apjschool.librarymgmt.dto.BookCategoryDTO;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.LanguageDTO;
import com.apjschool.librarymgmt.dto.PublisherDTO;
import com.apjschool.librarymgmt.dto.SearchFilter;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.service.BookService;
import com.apjschool.librarymgmt.service.MemberService;
import com.apjschool.librarymgmt.service.MiscService;

@RestController
@RequestMapping("/library")
public class LibrarySrviceController {

	private final Logger logger = LoggerFactory.getLogger(LibrarySrviceController.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MiscService miscService;

	/*
	 * @ResponseBody annotation means is that the returned value of the method will
	 * constitute the body of the HTTP response transformed to a format suitable for
	 * REST applications, typically JSON or XML.
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<BookDTO>> searchBook(/* @RequestBody SearchFilterRequest searchFilter */) {
		logger.info("Entering LibrarySrviceController.searchBook method");
		BaseResponse<List<BookDTO>> response = new BaseResponse();

		SearchFilterRequest searchFilter = new SearchFilterRequest();
		List<SearchFilter> filters = new ArrayList<>();
		// SearchFilter filter1 = new SearchFilter("bookIsdn", "0071772060");
		// filters.add(filter1);
		searchFilter.setSearchFilter(filters);

		ServiceResponse<List<BookDTO>> serviceResponse = bookService.searchBook(searchFilter);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Books Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<BookDTO> getBook(@RequestParam String bookId) {
		logger.info("Entering LibrarySrviceController.getBook method");
		BaseResponse<BookDTO> response = new BaseResponse<BookDTO>();

		ServiceResponse<BookDTO> serviceResponse = bookService.getBookById(Integer.parseInt(bookId));
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Books Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<Void> addBook(@RequestBody BookDTO bookDTO) {
		logger.info("Entering LibrarySrviceController.addBook method");
		BaseResponse<Void> response = new BaseResponse();
		// ServiceResponse<Void> serviceResponse = bookService.addBook(bookDTO);
		ServiceResponse<Void> serviceResponse = new ServiceResponse<>();
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Book Added Successfully");
			response.setCode(0);
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<AuthorDTO>> getAuthor() {
		logger.info("Entering LibrarySrviceController.getAuthor method");
		BaseResponse<List<AuthorDTO>> response = new BaseResponse();

		ServiceResponse<List<AuthorDTO>> serviceResponse = miscService.getAuthor();
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Authors Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/publishers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<PublisherDTO>> getPublishers() {
		logger.info("Entering LibrarySrviceController.getPublishers method");
		BaseResponse<List<PublisherDTO>> response = new BaseResponse();

		ServiceResponse<List<PublisherDTO>> serviceResponse = miscService.getPublishers();
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Publishers Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/languages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<LanguageDTO>> getLanguage() {
		logger.info("Entering LibrarySrviceController.getLanguage method");
		BaseResponse<List<LanguageDTO>> response = new BaseResponse();

		ServiceResponse<List<LanguageDTO>> serviceResponse = miscService.getlanguages();
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("Languages Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<BookCategoryDTO>> getBookCategory() {
		logger.info("Entering LibrarySrviceController.getBookCategory method");
		BaseResponse<List<BookCategoryDTO>> response = new BaseResponse();

		ServiceResponse<List<BookCategoryDTO>> serviceResponse = miscService.getBookCategory();
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response.setStatus("Success");
			response.setMessage("BookCategory Fetched Successfully");
			response.setCode(0);
			response.setResult(serviceResponse.getResult());
		} else {
			response.setStatus("Failure");
			response.setMessage(serviceResponse.getAllErrorMessage());
			response.setCode(100);
		}
		return response;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> test() {
		List<Integer> body = new ArrayList<Integer>();
		body.add(1);
		body.add(1);
		body.add(3);
		return new ResponseEntity<List<Integer>>(body, HttpStatus.OK);
	}

}
