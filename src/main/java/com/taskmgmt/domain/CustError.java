package com.taskmgmt.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class CustError {
	private final HttpStatus status;
	private final String message;
	private List<FieldError> fieldErrors = new ArrayList<>();

	public CustError(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public void addFieldError(String objectName, String fieldName, String msg) {
		FieldError error = new FieldError(objectName, fieldName, msg);
		fieldErrors.add(error);
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
