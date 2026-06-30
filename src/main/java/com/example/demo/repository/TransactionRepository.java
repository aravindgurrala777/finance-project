package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	List<Transaction> findByAccountAccountIdOrderByTransactionDateDesc(Long accountId);
	
	@Query("select t from Transaction t where DATE(t.transactionDate) = :date order by t.transactionDate desc")
	List<Transaction> findByTransactionDate(@Param("date") LocalDate date);
	
	@Query("select t from Transaction t  where t.account.customer.id = :customerId")
	Page<Transaction> findByCustomerId(@Param("customerId")Long customerId, Pageable pageable);
	
}
