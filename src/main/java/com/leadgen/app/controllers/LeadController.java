package com.leadgen.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadgen.app.dto.request.FetchLeadRequest;
import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.dto.response.FetchLeadResponse;
import com.leadgen.app.dto.response.LeadCreationResponse;
import com.leadgen.app.services.LeadgenMasterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/lead")
@Component
@Tag(name = "Inventory Controller", description = "This Controller contains all endpoints for inventory operations like purchase, lookup and iward/outward")
public class LeadController {

	@Autowired
	LeadgenMasterService leadgenMasterService;

	// api to create lead
	@PostMapping("/create")
	@Operation(method = "POST", summary = "Crete", description = "API to create leads")
	public LeadCreationResponse createLead(@RequestBody LeadDto leadDtoRequest) {
		log.info("Create lead API Request recieved");
		return leadgenMasterService.createLead(leadDtoRequest);
	}

	// api to get lead
	@PostMapping("/get")
	@Operation(method = "POST", summary = "Get", description = "API to fetch leads from mobile number")
	public FetchLeadResponse getLead(@RequestBody FetchLeadRequest getLeadRequest) {
		log.info("Get lead API Request recieved");
		return leadgenMasterService.getLead(getLeadRequest);
	}

}
