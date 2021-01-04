package com.abcbank.service;

import java.util.List;

import com.abcbank.entity.CustomerEntity;

public interface CustomerServiceInterface {
	CustomerEntity createProfileService(CustomerEntity fu);
	List<CustomerEntity> viewAllProfilefacebookService();
	public int applyLoanService();
}