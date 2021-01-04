package com.abcbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
import com.abcbank.repository.CustomerDAOInterface;
import com.abcbank.repository.LADDAOInterface;
@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerDAOInterface cd;
	@Autowired
	private LADDAOInterface ld;
	
	
	
	
	public CustomerEntity createProfileService(CustomerEntity fu) {
		return cd.save(fu);
		
		
	}
	
	
	
	public List<CustomerEntity> viewAllProfilefacebookService() {
		List<CustomerEntity> list=new ArrayList<>();
		cd.findAll().forEach(list1->list.add(list1));
		return list;
		}
		
	
	public int applyLoanService() {
		
      
		LADEntity d=new LADEntity();
         
         int i=0;
        // d.setLad_id(10);
        d.setPassword("sdghh");
        d.setStatus("Pending");
        ld.save(d);
        List<LADEntity> id1=new ArrayList<LADEntity>();
       // id1.add(d);
       CustomerEntity c = new CustomerEntity();
        c.setAddress("Mumbai");
       c.setLoan_id(185);
        c.setName("Madhu");
        c.setContact(64453782);
       
        c.setType_of_loan("car loan");
        c.setIncome(50000);
        c.setAcc_no(263563);
        c.setLad(id1);
       // lic.info("Your loan is applied");
       
        cd.save(c);
        d.setCust(c);
        ld.save(d);
       
        i=1;
        return i;

	}	

}
