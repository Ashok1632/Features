package com.yash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.yash.entity.EligibilityDetails;
import com.yash.repo.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {
	@Autowired
	private EligibilityDetailsRepo eligibilityDetailsRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
EligibilityDetails entity1=new EligibilityDetails();
entity1.setEligId(1);
entity1.setName("Ashok");
entity1.setMobile((long) 88875888);
entity1.setGender('M');
entity1.setSsn((long) 88475777);
entity1.setPlanName("CCAP");
entity1.setPlanStatus("Denied");
eligibilityDetailsRepo.save(entity1);


EligibilityDetails entity2=new EligibilityDetails();
entity1.setEligId(2);
entity1.setName("Bhushan");
entity1.setMobile((long) 77898599);
entity1.setGender('M');
entity1.setSsn((long) 87848988);
entity1.setPlanName("CCMM");
entity1.setPlanStatus("Accepted");
eligibilityDetailsRepo.save(entity1);
	}

}
