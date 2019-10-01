package com.apjschool.librarymgmt.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.apjschool.librarymgmt.controller.ServiceResponse;
import com.apjschool.librarymgmt.dto.BaseResponse;

@Component
public class LibraryUtil {

	public ResponseEntity<BaseResponse> getRestResponse(HttpStatus status, String message,
			ServiceResponse serviceResponse, String headerKey, String headerValue) {
		BaseResponse response = new BaseResponse();

		response.setStatus(status.name());
		response.setMessage(message);
		response.setCode(status.value());
		response.setResult(serviceResponse.getResult());
		if (headerKey != null && !headerKey.equals("")) {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(headerKey, headerValue);
			return new ResponseEntity<BaseResponse>(response, httpHeaders, status);

		}
		return new ResponseEntity<BaseResponse>(response, status);
	}
	
	public BaseResponse getBaseResponse(HttpStatus status, String message,
			ServiceResponse serviceResponse, String headerKey, String headerValue) {
		BaseResponse response = new BaseResponse();

		response.setStatus(status.name());
		response.setMessage(message);
		response.setCode(status.value());
		response.setResult(serviceResponse.getResult());
		return response;
	}

}
