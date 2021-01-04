package com.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.entity.AdminEntity;

@Repository
public interface AdminDAOInterface extends JpaRepository<AdminEntity,Long> {
	
}
