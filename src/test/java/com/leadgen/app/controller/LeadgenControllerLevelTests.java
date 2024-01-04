package com.leadgen.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.services.impls.LeadgenMasterServiceImpl;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "com.leadgen.app" })
@SpringBootTest
@EnableWebMvc
public class LeadgenControllerLevelTests {

	private final String URL = "http://localhost:8817/";
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	 private static final ObjectMapper MAPPER = new ObjectMapper()
			    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			    .registerModule(new JavaTimeModule());
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	LeadgenMasterServiceImpl leadgenMasterService;

	@Test
	public void testGetImagePath() throws Exception {
		LeadDto leadMaster = LeadDto.builder().firstName("abc").middleName("xyz").lastName("xyz")
				.email("dummy@email.com").gender("Male").leadId(String.valueOf(gen())).mobileNumber("9867893889")
				.dob(new Date()).build();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(leadMaster);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL + "lead/create")
				.content(requestJson).contentType(APPLICATION_JSON_UTF8);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse s = result.getResponse();
		assertEquals(200, s.getStatus(), "Response is successful");

	}

	public long gen() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextLong();
	}


}
