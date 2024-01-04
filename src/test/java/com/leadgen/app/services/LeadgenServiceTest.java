package com.leadgen.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.dto.response.LeadCreationResponse;
import com.leadgen.app.repositories.LeadMasterRepository;
import com.leadgen.app.services.impls.LeadValidationService;
import com.leadgen.app.services.impls.LeadgenMasterServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LeadgenServiceTest {

	@Mock
	private LeadMasterRepository leadMasterRepo;

	@Mock
	private LeadValidationService leadValidationService;
	
	@InjectMocks
	private LeadgenMasterServiceImpl leadgenMasterService;

	public long gen() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextLong();
	}

	@Test
	public void testAddition() {
		LeadDto leadMaster = LeadDto.builder().firstName("abc").middleName("xyz").lastName("xyz")
				.email("dummy@email.com").gender("Male").leadId(String.valueOf(gen())).mobileNumber("9867893889")
				.dob(new Date()).build();
		LeadCreationResponse leadCreationResponse = leadgenMasterService.createLead(leadMaster);
		assertEquals("success", leadCreationResponse.getStatus(), "Response is successful");
	}
	@Test
	public void testAddition2() {
		LeadDto leadMaster = LeadDto.builder().firstName("abc").middleName("xyz").lastName("xyz")
				.email("dummy@emailcom").gender("Male").leadId(String.valueOf(gen())).mobileNumber("9867893889")
				.dob(new Date()).build();
		LeadCreationResponse leadCreationResponse = leadgenMasterService.createLead(leadMaster);
		assertEquals("success", leadCreationResponse.getStatus(), "Response is successful");
	}
}
