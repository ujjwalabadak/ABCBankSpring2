package com.abcbank.service;

import java.util.List;



import com.abcbank.entity.AdminEntity;

public interface AdminServiceInterface {

	 public AdminEntity createProfileService(AdminEntity ad);

public	AdminEntity deleteProfileService(Long loanID);

//public	AdminEntity editProfileService(AdminEntity ad, long l);

public	List<AdminEntity> viewAllProfileService();

public AdminEntity editProfileService(AdminEntity ad, Long l);

public AdminEntity searchLoanService(Long loanID);
}