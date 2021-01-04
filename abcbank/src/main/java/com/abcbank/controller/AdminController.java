package com.abcbank.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.entity.AdminEntity;
import com.abcbank.service.AdminServiceInterface;



@RestController
public class AdminController {
	@Autowired
	private AdminServiceInterface ai;
	@PostMapping("createloan")
	public AdminEntity createProfile(@RequestBody AdminEntity ad) {
		//String str="Registration Fail";
		//AdminEntity i=ai.createProfileService(ad);
		//if(i!=null) {
			//str="Registration Success";
		//}
		//return str;
		return ai.createProfileService(ad);
	}
	
	@DeleteMapping("deleteloan/{loanID}")
	public String deleteProfile(@PathVariable("loanID") Long  loanID) {
		String str="loan not deleted";
		AdminEntity i=ai.deleteProfileService(loanID);
		if(i==null) {
			str="loan deleted";
		}
		return str;
	}
	@PutMapping("editloan/{loanID}")
	public AdminEntity editProfile(@RequestBody AdminEntity ad,@PathVariable("loanID") Long l) throws Exception{
		/*String str="profile not updated";
		AdminEntity i=ai.editProfileService(ad,l);
		if(i!=null) {
			str="profile updated";
		}
		return str+"of user"+l;
		*/
		return ai.editProfileService(ad, l);
	}
	
	/*
	 @PutMapping("updateAdmin/{id}")
	public Admin updateAdminController(@RequestBody Admin s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return as.updateAdminService(s, id);
	}*/
	
	@GetMapping("viewAllloan")
	public List<AdminEntity> viewAllProfile() {
	List<AdminEntity> ll=new ArrayList<AdminEntity>();
	ll=ai.viewAllProfileService();
	return ll;
	}
}



