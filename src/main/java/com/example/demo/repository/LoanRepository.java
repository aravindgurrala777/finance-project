package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long>{

	
	List<Loan> findByCustomerCustomerIdOrderByStartDateDesc(Long customerId);
	          
	List<Loan> findByStatus(String status);
	
	List<Loan> findByLoanType(String loanType);
	
	List<Loan> findByCustomerCustomerIdAndStatus(Long customerId , String status);
	
}
