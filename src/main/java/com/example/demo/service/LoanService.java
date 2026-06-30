package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.LoanRequest;
import com.example.demo.dto.response.LoanResponse;
import com.example.demo.entity.Loan;

public interface LoanService {

	LoanResponse createLoan(LoanRequest request);
	LoanResponse getLoanById(Long loanId);
	List<LoanResponse> getLoansByCustomerId(Long customerId);
	List<LoanResponse> getActiveLoansByCustomerId(Long customerId);
	LoanResponse updateLoanStatus(Long loanId , String status);
    ResponseEntity<?> deleteLoan(Long loanId);
	
	
}
