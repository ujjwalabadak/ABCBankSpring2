package com.abcbank.controllertest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abcbank.AbcbankApplication;
import com.abcbank.controller.AdminController;
import com.abcbank.entity.AdminEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import junit.framework.Assert;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbcbankApplication.class)
@WebMvcTest(value = AdminController.class)
class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private AdminController adminController;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testcreateProfile() throws Exception {
		String URI = "/createloan";
		AdminEntity admin = getAdminEntity();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminController.createProfile(Mockito.any(AdminEntity.class))).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	/*@Test
	void testviewAllProfile() throws Exception {
		String URI = "/viewAllloan/{id}";
		AdminEntity admin = getAdminEntity();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminController.viewAllProfile(Mockito.anyString())).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}*/
	
	@Test
	void testviewAllProfile() throws Exception {
		String URI = "/viewAllloan";
		List<AdminEntity> a = new ArrayList<AdminEntity>();
		AdminEntity admin = getAdminEntity();
		a.add(admin);
	    String jsonInput = this.converttoJson(a);
	    Mockito.when(adminController.viewAllProfile()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	

	@Test
	void testeditProfile() throws Exception {
		String URI = "/editloan/{loanID}";
		AdminEntity admin = getAdminEntity();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminController.editProfile(Mockito.any(AdminEntity.class), Mockito.anyLong())).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 5).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testdeleteProfile() throws Exception {
		String URI = "/deleteloan/{loanID}";
 
	    String r = "Record deleted Successfully";
	    
	    Mockito.when(adminController.deleteProfile(Mockito.anyLong())).thenReturn(r);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    //assertThat(jsonInput).isEqualTo(jsonOutput);
	    Assert.assertEquals(r, jsonOutput);
	}

	
	
	
	private AdminEntity getAdminEntity() {
		AdminEntity a = new AdminEntity();
		
		
		a.setDuration(2);
		a.setIncome(2214);
		a.setLoanID((long) 24);
		a.setRateofinterest(5.4);
		a.setStatus("pending");
		a.setTypeofloan("gloan");
		a.setName("abc");
		
		return a;
	}
	
	
	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}
	
}
