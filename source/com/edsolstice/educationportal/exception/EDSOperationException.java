package com.edsolstice.educationportal.exception;

public class EDSOperationException extends Exception {

	int errorCode;
	String errorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public EDSOperationException(int errorCode, String message){
		this.errorCode=errorCode;
		this.errorMessage=message;
	}

}
