package com.yash.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yash.entity.Plan;

public interface PlanService {
	Map<Integer, String> getPlanCategories();

	public boolean savePlan(Plan plan);

	public List<Plan> getAllPlans();

	public Plan getPlanById(Integer planId);

	public boolean updatePlan(Plan plan);

	public boolean deletePlanById(Integer planId);

	public boolean planStatusChange(Integer planId, String status);

}
