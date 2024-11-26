package com.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7071147420452282910L;
	private int errorCode;
	private String errorMessage;

	public CustomException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}
}
