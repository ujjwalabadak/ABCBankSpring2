package com.abcbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.entity.AdminEntity;
import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
import com.abcbank.service.AdminServiceInterface;
import com.abcbank.service.CustomerServiceInterface;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceInterface fs;
	@Autowired
	private AdminServiceInterface as;
	
	
	
	@PostMapping("createProfile")
	public String createProfile(@RequestBody CustomerEntity fu) {
		String str="Registration Fail";
		CustomerEntity i=fs.createProfileService(fu);
	            
		if(i!=null) {
			str="Registration Success";
		}
		return str;
	}
	
	
	@GetMapping("searchProfile/{loanID}")
	public AdminEntity searchLoancontroller(@PathVariable("loanID") Long loanID) {
		AdminEntity ae=new AdminEntity();
		ae=as.searchLoanService(loanID);
		return ae;
		}
	
	
	
	@GetMapping("viewAllProfilefacebook")
	public List<AdminEntity> viewAllProfile() {
	List<AdminEntity> ll=new ArrayList<AdminEntity>();
	ll=as.viewAllProfileService();
	return ll;
	}
	
	
	
	
	
	
	 @PostMapping("customerdetails")
		public String applyLoan() {
			String str="Failed";
			int i=fs.applyLoanService();
			if(i>0) {
				str=" Success";
			}
			return str;
	
	
	 }
	
}
