package com.yash.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ELIGIBILITY_DETAILS")
@Data
public class EligibilityDetails {
	@Id
	@Column(name="ELIG_ID")
private Integer eligId;
	private String Email_id;

private String name;
private Long mobile;
private Character gender;
private Long ssn;
private String planName;
private String planStatus;
private LocalDate planStartDate;
private LocalDate planEndDate;
private LocalDate createDate;
private LocalDate updateDate;
private String createdBy;
private String updatedBy;
public Integer getEId() {
	return eligId;
}
public void setEligId(Integer eligId) {
	this.eligId = eligId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
public Character getGender() {
	return gender;
}
public void setGender(Character gender) {
	this.gender = gender;
}
public Long getSsn() {
	return ssn;
}
public void setSsn(Long ssn) {
	this.ssn = ssn;
}
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
public LocalDate getCreateDate() {
	return createDate;
}
public void setCreateDate(LocalDate createDate) {
	this.createDate = createDate;
}
public LocalDate getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(LocalDate updateDate) {
	this.updateDate = updateDate;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}
public String getEmail_id() {
	return Email_id;
}
public void setEmail_id(String email_id) {
	Email_id = email_id;
}

}
