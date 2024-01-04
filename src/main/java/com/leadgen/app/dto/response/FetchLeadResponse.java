package com.leadgen.app.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leadgen.app.dto.request.LeadDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchLeadResponse {

	@JsonProperty("status")
	private String status;

	@JsonProperty("data")
	private List<LeadDto> leads = new ArrayList<>();


}
