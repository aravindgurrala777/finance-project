package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.request.InvestmentRequest;
import com.example.demo.dto.response.InvestmentResponse;
import com.example.demo.service.InvestmentService;
import com.example.demo.service.InvestmentServiceImpli;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/finance/investments")
@RequiredArgsConstructor
@Validated
@Tag(name = "Investemnt Details" , description = "Investment Management Details avaliable")
public class InvestmentController {
	
	@Autowired
	private  InvestmentServiceImpli investmentservice;
	
	
	@PostMapping
	@Operation(summary = "Create Investment")
	public ResponseEntity<InvestmentResponse> createInvestment(@Valid @RequestBody InvestmentRequest request){
		
		return new ResponseEntity<>(investmentservice.createInvestment(request) , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/{customerId}")
	@Operation(summary = "Get All Investments by Customer")
	public ResponseEntity<List<InvestmentResponse>> getInvestmentsByCustomers(@PathVariable Long customerId){
		
		return ResponseEntity.ok(investmentservice.getInvestmentsByCustomerId(customerId));
	}
	
	@PatchMapping("/{id}/status")
	@Operation(summary = "Update Investment status" , description = "Status : ACTIVE/MATURED/WITHDRAWN")
	public ResponseEntity<InvestmentResponse> updateStatus(@PathVariable Long id , @Valid @RequestParam String status){
		
		
		return ResponseEntity.ok(investmentservice.updateInvestmentStatus(id, status));
	}

	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Investment")
	public ResponseEntity<?> deleteInvestment(@PathVariable Long id){
		
		
		investmentservice.deleteInvestment(id);
		
		return ResponseEntity.ok("Investment Deleted successfullyy");
	}
	
	
	
}
