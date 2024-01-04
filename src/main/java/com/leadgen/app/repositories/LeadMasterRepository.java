package com.leadgen.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leadgen.app.dto.request.LeadDto;
import com.leadgen.app.entities.LeadMaster;

public interface LeadMasterRepository extends JpaRepository<LeadMaster, Long> {

	@Query(value = "Select new com.leadgen.app.dto.request.LeadDto("
			+ " CAST(master.leadId as text),master.firstName,master.middleName,"
			+ "master.lastName,master.mobileNumber,master.gender,master.dateOfBirth,"
			+ "master.email) from LeadMaster master where master.mobileNumber=:mobileNumber"
			+ " ORDER BY master.updatedAt desc")
	List<LeadDto> findByMobileNumber(@Param("mobileNumber") String mobileNumber);
	
	LeadMaster findByLeadId(Long leadId);
	
	
}
