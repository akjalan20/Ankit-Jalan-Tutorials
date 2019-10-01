package com.apjschool.librarymgmt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // to exclude null properties in json response
public class BaseResponse<T> {

	private String status;
	private String message;
	private Integer code;
	private T result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
