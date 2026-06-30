package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.InvestmentRequest;
import com.example.demo.dto.response.InvestmentResponse;

public interface InvestmentService {

	
	InvestmentResponse createInvestment(InvestmentRequest request);
	List<InvestmentResponse> getInvestmentsByCustomerId(Long customerId);
	List<InvestmentResponse> getActiveInvestmentsByCustomerId(Long customerId);
	InvestmentResponse updateInvestmentStatus(Long id , String status);
	ResponseEntity<?> deleteInvestment(Long id);
	
	
}
