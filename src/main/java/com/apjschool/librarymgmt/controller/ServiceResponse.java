package com.apjschool.librarymgmt.controller;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponse<T> {

	private List<String> erros;
	private T result;

	public void addError(String errorMessage) {
		if (erros == null) {
			erros = new ArrayList<>();
		}
		erros.add(errorMessage);
	}

	public Boolean isSuccess() {
		if (erros == null || erros.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getAllErrorMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		if (erros != null) {
			for (String error : erros) {
				messageBuilder.append(error);
			}
		}
		return messageBuilder.toString();
	}

}
