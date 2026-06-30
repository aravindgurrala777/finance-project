package com.example.demo.service;

import com.example.demo.controller.CustomerController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.InvestmentRequest;
import com.example.demo.dto.response.InvestmentResponse;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Investment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.InvestmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class InvestmentServiceImpli implements InvestmentService {

	
	private final InvestmentRepository investmentrepository;
	private final CustomerRepository customerrepository;


	
	@Override
	public InvestmentResponse createInvestment(InvestmentRequest request) {

	
		Customer customer = customerrepository.findById(request.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found : " + request.getCustomerId()));
		
				Investment investment = new Investment();
				investment.setCustomer(customer);
				investment.setInvestmentType(request.getInvestmentType().toUpperCase());
				investment.setAmount(request.getAmount());
				investment.setStartDate(request.getStartDate());
				investment.setMaturityDate(request.getMaturityDate());
				investment.setStatus("ACTIVE");
				investment.setCreatedDate(LocalDateTime.now());
				
				return toResponse(investmentrepository.save(investment));
				
				
		
	}
	
	
	@Override
	@Transactional()
	public List<InvestmentResponse> getInvestmentsByCustomerId(Long customerId) {

		List<Investment> investments = investmentrepository.findByCustomerCustomerIdAndStatus(customerId, "ACTIVE");
		return investments.stream().map(this::toResponse).collect(Collectors.toList());	
	}
	
	
	
	
	@Override
	@Transactional
	public InvestmentResponse updateInvestmentStatus(Long id, String status) {

        Investment investment = investmentrepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Investments Not found: " + id));
        		
        		
        
		if(status == null || status.isBlank()) {
			throw new IllegalArgumentException("Status cannot be null or empty");
		}
		
		List<String> validStatuses = List.of("ACTIVE" , "MATURED" , "WITHDRAWAN");
		
		String upperStatus = status.trim().toUpperCase();
		
		if(!validStatuses.contains(upperStatus)) {
			throw new IllegalArgumentException("Invalid Status. Allowed : " + validStatuses);
		}
		
		investment.setStatus(upperStatus);
		return toResponse(investment);
	}
	
	
	@Override
	@Transactional
	public ResponseEntity<?> deleteInvestment(Long id) {

		Investment investment = investmentrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Investment not found: " + id));
		investmentrepository.delete(investment);
		
	return ResponseEntity.ok("Investement Deleted successfully");
	
	}
	
	
	private InvestmentResponse toResponse(Investment investment) {
		
		 InvestmentResponse response = new InvestmentResponse();
		 response.setId(investment.getId());
		 response.setCustomerId(investment.getCustomer().getCustomerId());
		 response.setCustomerName(investment.getCustomer().getName());
		 response.setInvestmentType(investment.getInvestmentType());
		 response.setAmount(investment.getAmount());
		 response.setStartDate(investment.getStartDate());
		 response.setMaturityDate(investment.getMaturityDate());
		 response.setStatus(investment.getStatus());
		 response.setCreatedDate(investment.getCreatedDate());
		 
		 return response;
		
	}


	@Override
	public List<InvestmentResponse> getActiveInvestmentsByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
