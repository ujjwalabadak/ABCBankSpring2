package com.abcbank.service;

import java.util.List;

import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;

public interface LADServiceInterface {

	List<CustomerEntity> viewAllCustomerApplication();
   
	

//public	int ApproveLoanService(Long cust_id,String status);



LADEntity ApproveLoanService(String status, Long cust_id);



//List<LADEntity> getStatus(String status);



LADEntity getStatus(int lad_id);

//int createLADService(LADEntity ad);

}
