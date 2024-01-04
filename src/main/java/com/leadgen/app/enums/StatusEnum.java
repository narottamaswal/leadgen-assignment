package com.leadgen.app.enums;

public enum StatusEnum {

	SUCCESS("success"), 
	ERROR("error");

	private String code;
	private StatusEnum(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	
}
