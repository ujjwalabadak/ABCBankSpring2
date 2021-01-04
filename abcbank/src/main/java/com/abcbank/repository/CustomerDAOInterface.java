package com.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abcbank.entity.CustomerEntity;

@Repository
public interface CustomerDAOInterface extends JpaRepository<CustomerEntity, Long> {
	 
	
}
