package com.abcbank.controllertest;



import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.MediaType;
import com.abcbank.AbcbankApplication;
import com.abcbank.controller.LADController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbcbankApplication.class)
@WebMvcTest(value = LADController.class)

class LADControllerTest {

	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private LADController ladController;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void testviewAllVisitor() throws Exception {
		String URI = "/viewallcustomer";
		List<CustomerEntity> a = new ArrayList<CustomerEntity>();
		CustomerEntity cust = getCustomerEntity();
		a.add(cust);
	    String jsonInput = this.converttoJson(a);
	    Mockito.when(ladController.viewAllVisitor()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	@Test
	public void testaprooveloan() throws Exception {
		String URI = "/aprroveloan/{status}/{cust_id}";
		LADEntity lad=getLadEntity();
		String jsonInput = this.converttoJson(lad);

	  Mockito.when(ladController.approveloan(Mockito.anyString(),Mockito.anyLong())).thenReturn(lad);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"accept",26).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	   .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	private LADEntity getLadEntity() {
		LADEntity l = new LADEntity();
		l.setLad_id(2);
		l.setPassword("asdsd");
		l.setStatus("assd");
		l.setCust(null);
		return l;
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
	
	
	private String converttoJson(Object cust) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(cust);
	}
	
}


