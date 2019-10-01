package com.apjschool.librarymgmt.controller;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponse<T> {

	private List<String> errors;
	private T result;

	public void addError(String errorMessage) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(errorMessage);
	}

	public Boolean isSuccess() {
		if (errors == null || errors.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List<String> getErros() {
		return errors;
	}

	public void setErros(List<String> erros) {
		this.errors = erros;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getAllErrorMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		if (errors != null) {
			for (String error : errors) {
				messageBuilder.append(error);
			}
		}
		return messageBuilder.toString();
	}

}
