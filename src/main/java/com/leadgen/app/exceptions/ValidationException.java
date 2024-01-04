package com.leadgen.app.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"code",
	"messages"
})
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private transient String code;
	private transient List<String> errorMessages = new ArrayList<>();
	
	public ValidationException(String code, List<String> errorMessages) {
		super(code);
		this.code = code;
		this.errorMessages = errorMessages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
