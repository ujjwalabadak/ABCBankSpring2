package com.abcbank.servicetest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.h;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.abcbank.AbcbankApplication;

import com.abcbank.entity.CustomerEntity;

import com.abcbank.repository.CustomerDAOInterface;
import com.abcbank.repository.LADDAOInterface;
import com.abcbank.service.LADService;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbcbankApplication.class)
@WebMvcTest(value = LADService.class)
class LADServiceTest {

	@Autowired
	private LADService ladService;
	
	
	   
	@MockBean
	private CustomerDAOInterface customerRepository;
	
	@MockBean
	private LADDAOInterface ladRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	void testListAllLADController() throws Exception {

		List<CustomerEntity> a = new ArrayList<CustomerEntity>();
		
		CustomerEntity cust = getCustomerEntity();
		a.add(cust);
	    
	    Mockito.when(customerRepository.findAll()).thenReturn(a);
	   
	    List<CustomerEntity> result = ladService.viewAllCustomerApplication();
	        
	    assertThat(a).isEqualTo(result);
	}
	
	
	
	private CustomerEntity getCustomerEntity() {
		CustomerEntity a = new CustomerEntity();
		a.setCust_id(1);
		a.setAcc_no(1233);
		a.setAddress("asadsd");
		a.setContact(12345435);
		a.setIncome(12345);
		a.setLoan_id(23);
		a.setType_of_loan("home");
		return a;
		
	}
	
}
