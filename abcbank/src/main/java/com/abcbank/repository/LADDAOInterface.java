package com.abcbank.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.entity.CustomerEntity;
import com.abcbank.entity.LADEntity;
@Repository
public interface LADDAOInterface extends JpaRepository<LADEntity, Integer>  {
	//@Query("update  LADEntity  set status =:status where cust_id=:cust_id")
  //public int updateStatus(@Param("cust_id") Long cust_id,@Param("status") String status);
	@Modifying
	@Transactional
	@Query("update com.abcbank.entity.LADEntity SET status =:status where cust_id=:cust_id")
	public int updateStatus(String status,Long cust_id);	
	//@Query(" from com.abcbank.entity.LADEntity  where status =:status")
	//public List<LADEntity> viewbystatus(String status);
}
