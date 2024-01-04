package com.leadgen.app.services.impls;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadgen.app.constants.ApplicationConstants;
import com.leadgen.app.dto.request.FetchLeadRequest;
import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.dto.response.FetchLeadResponse;
import com.leadgen.app.dto.response.LeadCreationResponse;
import com.leadgen.app.entities.LeadMaster;
import com.leadgen.app.enums.ErrorsEnum;
import com.leadgen.app.enums.StatusEnum;
import com.leadgen.app.exceptions.ValidationException;
import com.leadgen.app.repositories.LeadMasterRepository;
import com.leadgen.app.services.LeadgenMasterService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LeadgenMasterServiceImpl implements LeadgenMasterService {

	private static final String LOGGER_PREFIX = "Leadgen Service  -> ";

	@Autowired
	private LeadMasterRepository leadMasterRepo;
	@Autowired
	private LeadValidationService leadValidationService;

	//function to create lead
	@Override
	public LeadCreationResponse createLead(LeadDto leadDtoRequest) {
		log.info("{} Lead Creation Request: {}", LOGGER_PREFIX, leadDtoRequest);
		leadValidationService.basicParamValidations(leadDtoRequest);
		leadValidationService.customValidations(leadDtoRequest);
		LeadMaster leadMaster = LeadMaster
				.builder()
				.firstName(leadDtoRequest.getFirstName())
				.middleName(leadDtoRequest.getMiddleName())
				.lastName(leadDtoRequest.getLastName())
				.email(leadDtoRequest.getEmail())
				.gender(leadDtoRequest.getGender())
				.leadId(Long.parseLong(leadDtoRequest.getLeadId()))
				.mobileNumber(leadDtoRequest.getMobileNumber())
				.dateOfBirth(leadDtoRequest.getDob()).build();
		leadMasterRepo.save(leadMaster);
		log.info("{} Successfully created lead with the following details: {}", LOGGER_PREFIX, leadDtoRequest);
		return new LeadCreationResponse(StatusEnum.SUCCESS.getCode(), ApplicationConstants.LEAD_SUCCESSUL_CREATED);
	}

	
	//function to get lead
	@Override
	public FetchLeadResponse getLead(FetchLeadRequest fetchLeadRequest) {
		log.info("{} Fetch Lead Request: {}", LOGGER_PREFIX, fetchLeadRequest);
		leadValidationService.basicParamValidations(fetchLeadRequest);
		List<LeadDto> leadsList = 
				leadMasterRepo.findByMobileNumber(fetchLeadRequest.getMobileNumber().trim());
		if(leadsList.isEmpty()) {
			throw new ValidationException(
				ErrorsEnum.NO_LEAD_FOUND.getCode(), Arrays.asList(ErrorsEnum.NO_LEAD_FOUND.getMessage())
			);
		}
		return new FetchLeadResponse(StatusEnum.SUCCESS.getCode(),leadsList);
		
	}

}
