package com.leadgen.app.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadCreationResponse {

	@JsonProperty("status")
	private String status;

	@JsonProperty("response")
	private String response;
}
