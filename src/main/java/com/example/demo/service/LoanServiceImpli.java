package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.LoanRequest;
import com.example.demo.dto.response.LoanResponse;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Loan;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.LoanRepository;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;

@Service
public class LoanServiceImpli implements LoanService {

	@Autowired
	private LoanRepository loanrepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	
	
	
	
	@Override
	public LoanResponse createLoan(LoanRequest request) {

		Customer customer = customerrepository.findById(request.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getCustomerId()));
		
		Loan loan = new Loan();
		loan.setCustomer(customer);
		loan.setLoanType(request.getLoanType().toUpperCase());
		loan.setPrincipalAmount(request.getPrincipalAmount());
		loan.setInterestRate(request.getInterestRate());
		loan.setStartDate(request.getStartDate());
		loan.setEndDate(request.getEndDate());
		loan.setStatus("ACTIVE");
		
		
		Loan savedLoan = loanrepository.save(loan);
		return toResponse(savedLoan);
	}

	@Override
	public LoanResponse getLoanById(Long loanId) {
			
		Loan loan = loanrepository.findById(loanId)
			.orElseThrow(() -> new ResourceNotFoundException("Loan not found with Id: " + loanId));
		
		return toResponse(loan);
	}

	@Override
	public List<LoanResponse> getLoansByCustomerId(Long customerId) {

		if(!customerrepository.existsById(customerId)) {
			throw new ResourceNotFoundException("Customer not found with Id: " + customerId);		
		}
		
		List<Loan> loans = loanrepository.findByCustomerCustomerIdOrderByStartDateDesc(customerId);
		return loans.stream().map(this::toResponse).collect(Collectors.toList());
		
	}

	@Override
	public List<LoanResponse> getActiveLoansByCustomerId(Long customerId) {

		List<Loan> loans = loanrepository.findByCustomerCustomerIdAndStatus(customerId, "ACTIVE");
		
				return loans.stream().map(this::toResponse).collect(Collectors.toList());
				
	}

	@Override
	@Transactional
	public LoanResponse updateLoanStatus(Long loanId, String status) {

		Loan loan = loanrepository.findById(loanId).orElseThrow(() -> new ResourceNotFoundException("Loan not found with Id: " + loanId));
		
		loan.setStatus(status.toUpperCase());
		return toResponse(loanrepository.save(loan));
		
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteLoan(Long loanId) {

		if(!loanrepository.existsById(loanId)) {
			throw new ResourceNotFoundException("Loan not found with ID: " + loanId);
		}
		
		loanrepository.deleteById(loanId);
		
		return ResponseEntity.ok("Loan deleted Successfullyy");
	}
	
	
	private LoanResponse toResponse(Loan loan) {
		
		
		LoanResponse response = new LoanResponse();
		response.setId(loan.getLoanId());
		response.setCustomerId(loan.getCustomer().getCustomerId());
		response.setCustomerName(loan.getCustomer().getName());
		response.setLoanType(loan.getLoanType());
		response.setPrincipalAmount(loan.getPrincipalAmount());
		response.setInterestRate(loan.getInterestRate());
		response.setStartDate(loan.getStartDate());
		response.setEndDate(loan.getEndDate());
		response.setStatus(loan.getStatus());
		
		return response;
		
	}
	
	

}
