package com.yash.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.request.SearchRequest;
import com.yash.response.SearchResponse;
import com.yash.service.ReportService;

import io.swagger.models.Response;

@RestController
public class ReportRestController {
@Autowired
private ReportService reportService;

@GetMapping("/plans")
public ResponseEntity<List<String>> getPlanNames()
{
	List<String> planNames = reportService.getUniquePlanNames();
	return new ResponseEntity<>(planNames,HttpStatus.OK);


}
@GetMapping("/statuses")
public ResponseEntity<List<String>> getPlanStatuses()
{
	List<String> statuses = reportService.getUniquePlanStatuses();
	return new ResponseEntity<>(statuses,HttpStatus.OK);
	
}
@PostMapping("/search")
public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest searchRequest)
{
	List<SearchResponse> responses = reportService.Search(searchRequest);
	return new ResponseEntity<>(responses,HttpStatus.OK);
	
}
@GetMapping("/excel")
public void excelReport(HttpServletResponse response) throws Exception
{
	response.setContentType("application/octet-stream");
	 String headerKey = "Content-Disposition";
     String headerValue = "attachment;filename=data.xls";
     response.setHeader(headerKey, headerValue);
     reportService.generateExcel(response);
}
@GetMapping("/pdf")
public void pdfReport(HttpServletResponse response) throws Exception
{
	response.setContentType("application/pdf");
	 String headerKey = "Content-Disposition";
     String headerValue = "attachment;filename=data.pdf";
     response.setHeader(headerKey, headerValue);
     reportService.generatePdf(response);
	
}







}