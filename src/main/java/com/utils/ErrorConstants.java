package com.utils;

public class ErrorConstants {

	public static final Integer SUCESS = 200;

	public static final Integer INTERNAL_SERVER_ERROR = 500;

	public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Oops! Something went wrong on our end. Please try again later.";

	public static final Integer DATA_NOT_FOUND = 1002;

	public static final Integer DUPLICATE_ENTRY = 1003;

	public static final Integer REQUIRED_FIELD_MISSING = 422;

	public static final String REQUIRED_FIELD_MISSING_MESSAGE = "Required fields are missing from the request.";

	public static final Integer INVALID_CREDENTIALS = 401; // Unauthorized

	public static final String INVALID_CREDENTIALS_MESSAGE = "Incorrect password. Please double-check and try again.";

	public static final String LOGIN_SUCESSFULLY_MESSAGE = "Login successful!";

}
