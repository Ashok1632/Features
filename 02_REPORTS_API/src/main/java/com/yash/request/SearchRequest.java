package com.yash.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
private String planName;
private String planStatus;
private LocalDate planStartDate;
private LocalDate planEndDate;
public String getPlanName() {
	return planName;
}
public void setPlanName(String planName) {
	this.planName = planName;
}
public String getPlanStatus() {
	return planStatus;
}
public void setPlanStatus(String planStatus) {
	this.planStatus = planStatus;
}
public LocalDate getPlanStartDate() {
	return planStartDate;
}
public void setPlanStartDate(LocalDate planStartDate) {
	this.planStartDate = planStartDate;
}
public LocalDate getPlanEndDate() {
	return planEndDate;
}
public void setPlanEndDate(LocalDate planEndDate) {
	this.planEndDate = planEndDate;
}


}
