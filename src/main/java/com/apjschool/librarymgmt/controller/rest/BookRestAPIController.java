package com.apjschool.librarymgmt.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apjschool.librarymgmt.controller.ServiceResponse;
import com.apjschool.librarymgmt.dto.BaseResponse;
import com.apjschool.librarymgmt.dto.BookDTO;
import com.apjschool.librarymgmt.dto.BookSearchDTO;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.service.BookService;
import com.apjschool.librarymgmt.util.LibraryUtil;

@RestController
@RequestMapping("/library/bookAPI")
public class BookRestAPIController {

	private final Logger logger = LoggerFactory.getLogger(BookRestAPIController.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private LibraryUtil libraryUtil;

	/*
	 * @ResponseBody annotation means is that the returned value of the method will
	 * constitute the body of the HTTP response transformed to a format suitable for
	 * REST applications, typically JSON or XML. If you have annotated a class
	 * with @RestController then you do not need to specify @ResponseBody. It is
	 * required only if you use @Controller instead of @RestController
	 */
	// @ResponseBody
	@RequestMapping(value = "/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> searchBook(@RequestBody SearchFilterRequest searchFilter) {
		logger.info("Entering LibrarySrviceController.searchBook method");

		/*List<SearchFilter> filters = new ArrayList<>();
		searchFilter.setSearchFilter(filters);*/
		ResponseEntity<BaseResponse> responseEntity = null;
		
		ServiceResponse<List<BookDTO>> serviceResponse = bookService.searchBook(searchFilter);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.FOUND, "Books Fetched Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	/*@RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> searchBook1(@RequestBody SearchDTO searchDTO) {
		logger.info("Entering LibrarySrviceController.searchBook method");

		ResponseEntity<BaseResponse> responseEntity = null;
		
		ServiceResponse<List<BookDTO>> serviceResponse = bookService.searchBook(searchDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.FOUND, "Books Fetched Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}*/
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<BookDTO>> searchBook1(@RequestBody BookSearchDTO searchDTO) {
		logger.info("Entering LibrarySrviceController.searchBook method");

		BaseResponse<List<BookDTO>> response = null;
		ServiceResponse<List<BookDTO>> serviceResponse = bookService.searchBook(searchDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			if(serviceResponse.getResult().size()>0) {
				response = libraryUtil.getBaseResponse(HttpStatus.FOUND, "Records Fetched Successfully",  serviceResponse, null, null);
			} else {
				response = libraryUtil.getBaseResponse(HttpStatus.OK, "No Records Found",  serviceResponse, null, null);
			}
		} else {
			response = libraryUtil.getBaseResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),  serviceResponse, null, null);
		}
		return response;
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> getBookByRequestParamExample(@RequestParam String bookId) {
		logger.info("Entering LibrarySrviceController.getBook method");
		return getBook(bookId);
	}

	@RequestMapping(value = "/getBook/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> getBookByPathVariableExample(@PathVariable String bookId) {
		logger.info("Entering LibrarySrviceController.getBook method");
		return getBook(bookId);
	}

	private ResponseEntity<BaseResponse> getBook(String bookId) {
		ServiceResponse<BookDTO> serviceResponse = bookService.getBookById(Integer.parseInt(bookId));
		ResponseEntity<BaseResponse> responseEntity = null;
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.FOUND, "Books Fetched Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> addBook(@RequestBody BookDTO bookDTO) {
		logger.info("Entering LibrarySrviceController.addBook method");
		BaseResponse<BookDTO> response = new BaseResponse<BookDTO>();
		/*
		 * Use response entity to add http headers, http status etc in the response as
		 * shown below
		 */
		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<BookDTO> serviceResponse = bookService.addBook(bookDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.CREATED, "Books Added Successfully",
					serviceResponse, "resource URI", ServletUriComponentsBuilder.fromCurrentRequest().path("/getBook/")
					.buildAndExpand(serviceResponse.getResult().getBookId()).toUri().toString());
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, "resource URI", ServletUriComponentsBuilder.fromCurrentRequest().path("/getBook/")
					.buildAndExpand(serviceResponse.getResult().getBookId()).toUri().toString());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> deleteBook(@RequestBody BookDTO bookDTO) {
		logger.info("Entering LibrarySrviceController.deleteBook method");
		BaseResponse<BookDTO> response = new BaseResponse<BookDTO>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = bookService.deleteBook(bookDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.CREATED, "Books Deleted Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> updateBook(@RequestBody BookDTO bookDTO) {
		logger.info("Entering LibrarySrviceController.addBook method");
		BaseResponse<Void> response = new BaseResponse<Void>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = bookService.updateBook(bookDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.CREATED, "Books Updated Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}

}
