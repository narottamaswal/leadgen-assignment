package com.leadgen.app.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FetchLeadRequest {

	@NotNull(message = "Mobile number cannot be null")
	@Pattern(regexp = "^[6789]\\d{9}$",message="Mobile number format is invalid, please check.")	
	@JsonProperty("mobileNumber")
	private String mobileNumber;

}
