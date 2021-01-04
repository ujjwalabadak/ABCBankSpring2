package com.abcbank.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.entity.AdminEntity;
import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
import com.abcbank.service.LADServiceInterface;


@RestController
public class LADController {
	@Autowired
	private LADServiceInterface ls;
	@GetMapping("viewallcustomer")
	public List<CustomerEntity> viewAllVisitor(){
		
		List<CustomerEntity> ll=new ArrayList<CustomerEntity>();
		ll=ls.viewAllCustomerApplication();
		return ll;
		
	}
	@GetMapping("getstatus/{lad_id}")
	public LADEntity getStatusC(@PathVariable("lad_id") int lad_id){
		LADEntity ll=new LADEntity();
		ll=ls.getStatus(lad_id);
		return ll;
	}
	
	/*
	 @PutMapping("aprroveloan")
	public int approveloan(@PathParam("cust_id") Long cust_id,@PathParam("status") String status) {
		
				 int l=ls.ApproveLoanService(cust_id, status);
				return l;
		
		
	}*/
	/* @PostMapping("laddetails")
		public String createLAD(@RequestBody LADEntity ad) {
			String str="Failed";
			int i=ls.createLADService(ad);
			if(i>0) {
				str=" Success";
			}
			return str;
	 
}*/
	 @PutMapping("aprroveloan/{status}/{cust_id}")
	 		
		public LADEntity approveloan(@PathVariable("status") String status,@PathVariable("cust_id") Long cust_id) {
		 return ls.ApproveLoanService(status,cust_id);
		
					
		}
	
		  }

