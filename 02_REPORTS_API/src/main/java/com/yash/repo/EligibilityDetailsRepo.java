package com.yash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.entity.EligibilityDetails;
@Repository
public interface EligibilityDetailsRepo extends JpaRepository<EligibilityDetails, Integer> {
    @Query("select distinct(planName) from EligibilityDetails")
	List<String> findPlanNames();
    
    @Query("select distinct(planStatus) from EligibilityDetails")
   	List<String> findPlanStatuses();

	
	
}
