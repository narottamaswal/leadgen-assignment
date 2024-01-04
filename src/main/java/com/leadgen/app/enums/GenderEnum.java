package com.leadgen.app.enums;

public enum GenderEnum {

	MALE("MALE"), 
	FEMALE("FEMALE"), 
	OTHERS("OTHERS");

	private String code;
	private GenderEnum(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public static boolean isValidGender(String code) {
		for(GenderEnum gender:GenderEnum.values()) {
			if(gender.getCode().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}
	
}
