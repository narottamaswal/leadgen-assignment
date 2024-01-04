package com.leadgen.app.services.impls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.entities.LeadMaster;
import com.leadgen.app.enums.ErrorsEnum;
import com.leadgen.app.enums.GenderEnum;
import com.leadgen.app.exceptions.ErrorTypeConstants;
import com.leadgen.app.exceptions.ValidationException;
import com.leadgen.app.repositories.LeadMasterRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LeadValidationService {

	@Autowired
	private LeadMasterRepository leadMasterRepo;

	// generic function to do basic data type validations
	public <T> void basicParamValidations(T request) {
		List<String> errors = new ArrayList<>();
		Set<ConstraintViolation<T>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(request);
		for (ConstraintViolation<T> constaintViolation : constraintViolations) {
			errors.add(constaintViolation.getMessage());
		}
		if (!constraintViolations.isEmpty()) {
			log.error("Basic data type validations failed");
			throw new ValidationException(ErrorsEnum.BAD_REQUEST.getCode(), errors);
		}

	}

	// custom function for validations
	public void customValidations(LeadDto leadDtoRequest) {
		if (!GenderEnum.isValidGender(leadDtoRequest.getGender())) {
			log.error("Gender is invalid, throwing bad request error");
			throw new ValidationException(ErrorsEnum.BAD_REQUEST.getCode(),
					Arrays.asList(ErrorTypeConstants.INVALID_GENDER));
		}
		LeadMaster leadMaster = leadMasterRepo.findByLeadId(Long.parseLong(leadDtoRequest.getLeadId().trim()));
		if (leadMaster != null) {
			log.error("Gender with the given lead id already exists");
			throw new ValidationException(ErrorsEnum.LEAD_ALREADY_EXISITS.getCode(),
					Arrays.asList(ErrorsEnum.LEAD_ALREADY_EXISITS.getMessage()));
		}
	}

}
