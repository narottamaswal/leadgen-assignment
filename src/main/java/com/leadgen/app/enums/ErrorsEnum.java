package com.leadgen.app.enums;

public enum ErrorsEnum {

	BAD_REQUEST("E10009", "Invalid Request"), 
	NO_LEAD_FOUND("E10010", "No Lead found with the Mobile Number"), 
	LEAD_ALREADY_EXISITS("E10011", "Lead Already Exists in the database with the lead id");

	private String code;
	private String message;
	private ErrorsEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
