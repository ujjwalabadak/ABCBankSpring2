package com.abcbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.entity.AdminEntity;
import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
import com.abcbank.repository.AdminDAOInterface;
@Service
public class AdminService implements AdminServiceInterface {
	@Autowired
	private AdminDAOInterface ai;
		@Override
		public AdminEntity createProfileService(AdminEntity ad) {

			return ai.save(ad);
		}

		@Override
		public AdminEntity deleteProfileService(Long loanID) {

			//ai.deleteById(loanID);
			ai.deleteById(loanID);
			return null;
		}

		@Override
		//public AdminEntity editProfileService(AdminEntity ad, String loanID) {
		public AdminEntity editProfileService(AdminEntity ad, Long l) {
			return ai.save(ad);
			
		}

		
		@Override
		public List<AdminEntity> viewAllProfileService() {
		List<AdminEntity> list=new ArrayList<>();
		ai.findAll().forEach(list1->list.add(list1));
		return list;
		}

		@Override
		public AdminEntity searchLoanService(Long loanID) {
			
			return ai.findById(loanID).orElse(null);
		}

	

}


