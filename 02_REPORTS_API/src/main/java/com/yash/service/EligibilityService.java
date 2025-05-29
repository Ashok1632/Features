package com.yash.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yash.entity.EligibilityDetails;
import com.yash.request.SearchRequest;
import com.yash.response.SearchResponse;

public interface EligibilityService {
public Map<String,Integer> getReport();
public List<EligibilityDetails> getAllEligibilityDtls();
public EligibilityDetails getEligibilityDtlsById(Integer planId);
public boolean deleteEligibilityDtlsById(Integer eligibilityId);
public boolean updateEligibilityDtls(EligibilityDetails eligibilityDtls);
//public List<planName> getAllPlans();
//public List<planStatus> getAllPlans();

}
