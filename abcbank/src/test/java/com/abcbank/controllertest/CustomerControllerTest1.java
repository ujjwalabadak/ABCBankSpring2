package com.abcbank.controllertest;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abcbank.AbcbankApplication;
import com.abcbank.controller.CustomerController;
import com.abcbank.entity.AdminEntity;
import com.abcbank.entity.CustomerEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbcbankApplication.class)
@WebMvcTest(value = CustomerController.class)
class CustomerControllerTest1 {

	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private CustomerController customercontroller;
	
	
	//@MockBean
	//private AdminController admincontroller;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*@Test
	void testcreateProfile() throws Exception {
		String URI = "/createProfile";
		CustomerEntity cust = getCustomerEntity();
	    String jsonInput = this.converttoJson(cust);

	    Mockito.when(customercontroller.createProfile(Mockito.any(CustomerEntity.class))).thenReturn(cust);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	/*
	 @Test
	void testListAllAdminController() throws Exception {
		String URI = "/listAllAdmin";
		List<Admin> a = new ArrayList<Admin>();
		
		Admin admin = getAdmin();
		a.add(admin);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(adminService.listAllAdminService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	 */
	
	@Test
	void testviewAllProfile() throws Exception {
		String URI = "/viewAllProfilefacebook";
		List<AdminEntity> a = new ArrayList<AdminEntity>();
		
		AdminEntity admin = getAdminEntity();
		a.add(admin);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(customercontroller.viewAllProfile()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	@Test
	void testsearchByIdController() throws Exception {
		String URI = "/searchProfilefacebook";
		AdminEntity admin = getAdminEntity();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(customercontroller.searchLoancontroller((Long) Mockito.anyLong())).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 12).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	  //  assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	

	
	private CustomerEntity getCustomerEntity() {
		CustomerEntity b = new CustomerEntity();
		
		b.setAcc_no(35);
		b.setAddress("eaet");
	//	b.setAdmin1("abc");
		b.setContact(4624);
		b.setCust_id(5);
		b.setIncome(452);
		b.setLoan_id(4);
		b.setName("aaa");
		b.setType_of_loan("hgafa");
		return b;
	}
	
	
	private AdminEntity getAdminEntity() {
		AdminEntity a = new AdminEntity();
		
		
		a.setDuration(2);
		a.setIncome(40000);
	    a.setLoanID(12L);
		//a.setRateofinterest(5.4);
		a.setStatus("pending");
		a.setTypeofloan("home loan");
		a.setName("neha");
		
		return a;
	}
	
	
	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}
	
}

