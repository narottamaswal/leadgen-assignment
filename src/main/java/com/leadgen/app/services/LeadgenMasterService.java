package com.leadgen.app.services;

import com.leadgen.app.dto.request.FetchLeadRequest;
import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.dto.response.FetchLeadResponse;
import com.leadgen.app.dto.response.LeadCreationResponse;

public interface LeadgenMasterService {

	LeadCreationResponse createLead(LeadDto leadDtoRequest);

	FetchLeadResponse getLead(FetchLeadRequest fetchLeadRequest);

}
