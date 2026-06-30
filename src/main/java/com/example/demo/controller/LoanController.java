package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LoanRequest;
import com.example.demo.dto.response.LoanResponse;
import com.example.demo.service.LoanServiceImpli;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Validated
@Tag(name = "Loan Details" , description = "All Loan details of the Accounts are listed")
@RequestMapping("finance/loans")
public class LoanController {

	@Autowired
	private LoanServiceImpli loanservice;
	
	@PostMapping
	@Operation(summary = "Creates Loan" , description = "Loans are created by the status eligibility")
	public ResponseEntity<LoanResponse> createLoan(@Valid @RequestBody LoanRequest request){
		
		LoanResponse response = loanservice.createLoan(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Loans by Id" , description = "Loans are listed based on Ids")
	public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long id){
		return ResponseEntity.ok(loanservice.getLoanById(id));
	}
	
	@GetMapping("/customer/{customerId}")
	@Operation(summary = "Loans by CustomerId" , description = "Loans are listed based on Customer Ids")
	public ResponseEntity<List<LoanResponse>> getLoansByCustomer(@PathVariable Long customerId){
		return ResponseEntity.ok(loanservice.getLoansByCustomerId(customerId));
	}
	
	
	@GetMapping("/customer/{customerId}/active")
	@Operation(summary = "Active Loans" , description = "Active Loans are Listed")
	public ResponseEntity<List<LoanResponse>> getActiveLoans(@PathVariable Long customerId ){
		return ResponseEntity.ok(loanservice.getActiveLoansByCustomerId(customerId));
	}
	
	@PatchMapping("/{id}/status")
	@Operation(summary = "Updates the status" , description = "Updates the status Active/Closed")
	public ResponseEntity<LoanResponse> updateStatus(@PathVariable Long id,@RequestParam String status){
		return ResponseEntity.ok(loanservice.updateLoanStatus(id, status));
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletes the Loan" , description = "Delete the Loan on their Id")
	public ResponseEntity<?> deleteLoan(@PathVariable Long id){
		
		loanservice.deleteLoan(id);
		
		return ResponseEntity.ok("Loan Deleted Successfullyy");
	}
	
}
