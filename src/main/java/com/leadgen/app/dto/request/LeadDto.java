package com.leadgen.app.dto.request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LeadDto {

	@NotNull(message = "Lead id cannot be null")
    @Pattern(regexp = "^[0-9]*$",message = "Lead id should only contain numbers.")
	@JsonProperty("leadId")
	private String leadId;

	@NotNull(message = "First name cannot be null")
	@Pattern(regexp = "^[a-zA-Z]*$",message="First name should only contain alphanumeric characters with no spaces.")	
	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("middleName")
	@Pattern(regexp = "^[a-zA-Z]*$",message="Middle name should only contain alphanumeric characters with no spaces.")	
	private String middleName;

	@NotNull(message = "Last name cannot be null")
	@Pattern(regexp = "^[a-zA-Z]*$",message="Last name should only contain alphanumeric characters with no spaces.")	
	@JsonProperty("lastName")
	private String lastName;

	@NotNull(message = "Mobile number cannot be null")
	@Pattern(regexp = "^[6789]\\d{9}$",message="Mobile number format is invalid, please check.")	
	@JsonProperty("mobileNumber")
	private String mobileNumber;

	@NotNull(message = "Gender cannot be null")
	@JsonProperty("gender")
	private String gender;

	@NotNull(message = "Date of birth cannot be null")
	@JsonProperty("DOB")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date dob;

	@NotNull(message = "Email address cannot be null")
	@Pattern(
	 regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
	 message="Email address format is invalid, please check."
	)	
	@JsonProperty("email")
	private String email;

}
