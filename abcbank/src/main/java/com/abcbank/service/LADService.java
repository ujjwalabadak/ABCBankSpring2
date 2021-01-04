package com.abcbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.entity.AdminEntity;
import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
import com.abcbank.repository.CustomerDAOInterface;
import com.abcbank.repository.LADDAOInterface;


@Service
public class LADService implements LADServiceInterface{
	@Autowired
	private CustomerDAOInterface la;
	@Autowired
	private LADDAOInterface ld;
	@Override
	public List<CustomerEntity> viewAllCustomerApplication() {
		List<CustomerEntity> list=new ArrayList<>();
		la.findAll().forEach(list1->list.add(list1));
		
		return list;
}
	@Override
	public LADEntity getStatus(int lad_id) {
		
		return ld.findById(lad_id).orElse(null);
	}
	
	
	
	
	/*@Override
	public int ApproveLoanService(Long cust_id,String status) {
		return ld.updateStatus(cust_id, status);
	}*/
	@Override
	public LADEntity ApproveLoanService(String status,Long cust_id) {
		int i=ld.updateStatus(status,cust_id);
		LADEntity l=null;
			if(i>0) {
				l = new LADEntity();
				l.setLad_id(2);
				l.setPassword("asdsd");
				l.setStatus("assd");
				//l.setCust(getCustomerEntity());
			
			}
			return l;
		}
		/*private CustomerEntity getCustomerEntity() {
			CustomerEntity a = new CustomerEntity();
			a.setCust_id(1);
			a.setAcc_no(1233);
			a.setAddress("asadsd");
			a.setContact(12345435);
			a.setIncome(12345);
			a.setLoan_id(23);
			a.setType_of_loan("home");
			return a;
			
	}*/
		
		
		
		
		
		
		
		
		
		
         /*int i=0;
			List<CustomerEntity> list=new ArrayList();
		//list=ld.findByIncome(income);
	  
	    if(list)
	    {
	    	Customer l1= new Customer();
	    	l1.setCust_id(id);
	    	
	    	 Query q2 = em.createQuery("update LAD set status =:status where cust1=:cust_id");
		        q2.setParameter("status", "Approved");
		        q2.setParameter("cust_id", l1);
		        q2.executeUpdate();
		        lic.info("Approved");
	    }
	
	    else
	    {	Customer l2= new Customer();
    	l2.setCust_id(id);
	    	 Query q2 = em.createQuery("update com.abcloan.LAD c set c.status =:status where c.cust1=:cust_id");
		        q2.setParameter("status", " Rejected");
		        q2.setParameter("cust_id", l2);
		        q2.executeUpdate();
		     
		        lic.info("Rejected");
	    }
	    }
	    else {
	    	
	    	// lic.info("No pending requests");
	    }
	    t.commit(); 
	    em.close();
	
	
		i=1;
		return i;
		
	}
	
	
	
	
	
	
	/*@Override
	public int createLADService(LADEntity ad) {
		
		
	}*/
}
