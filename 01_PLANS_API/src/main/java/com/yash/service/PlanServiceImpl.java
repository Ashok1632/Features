package com.yash.service;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entity.Plan;
import com.yash.entity.PlanCategory;
import com.yash.repo.PlanCategoryRepo;
import com.yash.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan saved=planRepo.save(plan);
		/*
		 * if(saved.getPlanId()!=null) { return true; } else { return false; }
		 */
	/*	return saved.getPlanId()!=null?true:false; 1 Year experienceYear code*/ 
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return planRepo.findAll();
		
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);//ctrl+1+enter
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		// TODO Auto-generated method stub
		/*
		 * Plan plan=new Plan(); plan.setPlanId(planId); plan.setActiveSw(status);
		 * planRepo.save(plan);
		 */
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent())
		{
			Plan plan=findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
