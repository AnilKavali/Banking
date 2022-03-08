package com.manager.curd.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manager.curd.model.Accounts;

public interface ManagerRepository extends JpaRepository<Accounts, Integer>{
	
	@Query("select a from Accounts a where a.accttype=?1")
	 public Optional<Accounts> findByAccType(String accttype);

}
