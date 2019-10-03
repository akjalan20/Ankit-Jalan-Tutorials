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
import com.apjschool.librarymgmt.dto.BookIssuedDTO;
import com.apjschool.librarymgmt.dto.MemberDTO;
import com.apjschool.librarymgmt.dto.BookSearchDTO;
import com.apjschool.librarymgmt.dto.MemberDTO;
import com.apjschool.librarymgmt.dto.MemberSearchDTO;
import com.apjschool.librarymgmt.dto.SearchFilterRequest;
import com.apjschool.librarymgmt.service.BookService;
import com.apjschool.librarymgmt.service.MemberService;
import com.apjschool.librarymgmt.util.LibraryUtil;

@RestController
@RequestMapping("/library/memberAPI")
public class MemberRestAPIController {

	private final Logger logger = LoggerFactory.getLogger(MemberRestAPIController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private LibraryUtil libraryUtil;

	@RequestMapping(value = "/members", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> searchMember(@RequestBody SearchFilterRequest searchFilter) {
		logger.info("Entering LibrarySrviceController.searchMember method");

		ResponseEntity<BaseResponse> responseEntity = null;
		
		ServiceResponse<List<MemberDTO>> serviceResponse = memberService.searchMember(searchFilter);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.FOUND, "Records Fetched Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<List<MemberDTO>> searchMembers(@RequestBody MemberSearchDTO searchDTO) {
		logger.info("Entering LibrarySrviceController.searchBook method");

		BaseResponse<List<MemberDTO>> response = null;
		ServiceResponse<List<MemberDTO>> serviceResponse = memberService.searchMember(searchDTO);
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

	@RequestMapping(value = "/getMember", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<MemberDTO> getBookByRequestParamExample(@RequestParam String memberId) {
		logger.info("Entering LibrarySrviceController.getBookByRequestParamExample method");
		return getMember(memberId);
	}

	@RequestMapping(value = "/getMember/{memberId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<MemberDTO> getBookByPathVariableExample(@PathVariable String memberId) {
		logger.info("Entering LibrarySrviceController.getBookByPathVariableExample method");
		return getMember(memberId);
	}

	private BaseResponse<MemberDTO> getMember(String memberId) {
		ServiceResponse<MemberDTO> serviceResponse = memberService.getMemberById(Integer.parseInt(memberId));
		BaseResponse<MemberDTO> baseResponse = null;
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			baseResponse = libraryUtil.getBaseResponse(HttpStatus.FOUND, "Member Fetched Successfully",
					serviceResponse, null, null);
		} else {
			baseResponse = libraryUtil.getBaseResponse(HttpStatus.NOT_FOUND, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return baseResponse;
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> addMember(@RequestBody MemberDTO memberDTO) {
		logger.info("Entering LibrarySrviceController.addMember method");
		BaseResponse<MemberDTO> response = new BaseResponse<MemberDTO>();
		/*
		 * Use response entity to add http headers, http status etc in the response as
		 * shown below
		 */
		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<MemberDTO> serviceResponse = memberService.addMember(memberDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.CREATED, "Books Added Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> deleteMember(@RequestBody MemberDTO memberDTO) {
		logger.info("Entering LibrarySrviceController.deleteMember method");
		BaseResponse<MemberDTO> response = new BaseResponse<MemberDTO>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = memberService.deleteMember(memberDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.OK, "Member Deleted Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> updateMember(@RequestBody MemberDTO memberDTO) {
		logger.info("Entering LibrarySrviceController.updateMember method");
		BaseResponse<Void> response = new BaseResponse<Void>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = memberService.updateMember(memberDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.CREATED, "Member Updated Successfully",
					serviceResponse, null, null);
		} else {
			responseEntity = libraryUtil.getRestResponse(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getAllErrorMessage(),
					serviceResponse, null, null);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/issue", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<Void> issueBook(@RequestBody BookIssuedDTO bookIssuedDTO) {
		logger.info("Entering LibrarySrviceController.issueBook method");
		BaseResponse<Void> response = new BaseResponse<Void>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = memberService.issueBook(bookIssuedDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response = libraryUtil.getBaseResponse(HttpStatus.FOUND, "Book Issued Successfully",  serviceResponse, null, null);
		} else {
			response = libraryUtil.getBaseResponse(HttpStatus.FOUND, serviceResponse.getAllErrorMessage(),  serviceResponse, null, null);
		}
		return response;
	}
	
	@RequestMapping(value = "/return", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<Void> returnBook(@RequestBody BookIssuedDTO bookIssuedDTO) {
		logger.info("Entering LibrarySrviceController.returnBook method");
		BaseResponse<Void> response = new BaseResponse<Void>();

		ResponseEntity<BaseResponse> responseEntity = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		ServiceResponse<Void> serviceResponse = memberService.returnBook(bookIssuedDTO);
		if (serviceResponse != null && serviceResponse.isSuccess()) {
			response = libraryUtil.getBaseResponse(HttpStatus.FOUND, "Book Returned Successfully",  serviceResponse, null, null);
		} else {
			response = libraryUtil.getBaseResponse(HttpStatus.FOUND, serviceResponse.getAllErrorMessage(),  serviceResponse, null, null);
		}
		return response;
	}

}
