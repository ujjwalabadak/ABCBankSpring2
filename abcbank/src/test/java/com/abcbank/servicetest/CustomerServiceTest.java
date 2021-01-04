package com.abcbank.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.abcbank.AbcbankApplication;
import com.abcbank.entity.AdminEntity;
import com.abcbank.repository.AdminDAOInterface;
import com.abcbank.service.AdminService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbcbankApplication.class)
@WebMvcTest(value = AdminService.class)
class CustomerServiceTest {

	@Autowired
	private AdminService adminService;
	   
	@MockBean
	private AdminDAOInterface adminDAOInterface;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateAdminController() throws Exception {
		AdminEntity admin = getAdminEntity();
	   
	    Mockito.when(adminDAOInterface.save(Mockito.any(AdminEntity.class))).thenReturn(admin);
	    
	    AdminEntity result = adminService.createProfileService(admin);
	    
	    assertThat(admin).isEqualTo(result);

	}

	

	@Test
	void testsearchprofile() throws Exception {
		
		Optional<AdminEntity> a = Optional.of(getAdminEntity());
		
		
		AdminEntity admin = getAdminEntity();
	  
	    Mockito.when(adminDAOInterface.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(adminDAOInterface.save(Mockito.any(AdminEntity.class))).thenReturn(admin);
	    
	    AdminEntity result = adminService.searchLoanService(12L);
	    
	   // assertThat(admin).isEqualTo(result);
	}

	
	
	

	@Test
	void testViewAllAdminController() throws Exception {

		List<AdminEntity> a = new ArrayList<AdminEntity>();
		
		AdminEntity admin = getAdminEntity();
		a.add(admin);
	    
	    Mockito.when(adminDAOInterface.findAll()).thenReturn(a);
	   
	    List<AdminEntity> result = adminService.viewAllProfileService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private AdminEntity getAdminEntity() {
		AdminEntity a = new AdminEntity();
		
		a.setDuration(2);
		a.setIncome(40000);
		a.setLoanID(12L);
		a.setName("neha");
	//	a.setRateofinterest(3.4);
		a.setStatus("pending");
		a.setTypeofloan("home loan");
		
		return a;
	}
}
