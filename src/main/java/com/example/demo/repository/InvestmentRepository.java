package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	List<Investment> findByCustomerCustomerId(Long customerId);
	
	List<Investment> findByCustomerCustomerIdAndStatus(Long customerId , String status);
	
	List<Investment> findByStatusAndMaturityDateBefore(String status,LocalDate date);
	
	
}
