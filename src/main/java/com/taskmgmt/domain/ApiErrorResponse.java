package com.taskmgmt.domain;

public class ApiErrorResponse {

	private int status;
	private int code;
	private String message;
	private String error;

	public ApiErrorResponse(int status, int code, String message, String error) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse{" + "status=" + status + ", code=" + code
				+ ", message=" + message + ", error=" + error + '}';
	}
}