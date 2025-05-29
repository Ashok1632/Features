package com.yash.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yash.entity.EligibilityDetails;
import com.yash.request.SearchRequest;
import com.yash.response.SearchResponse;

public interface ReportService {

	public List<String> getUniquePlanNames();
	public List<String> getUniquePlanStatuses();
	public List<SearchResponse> Search(SearchRequest request);
	public void generateExcel(HttpServletResponse response) throws Exception;
	public void generatePdf(HttpServletResponse response) throws Exception;



}
