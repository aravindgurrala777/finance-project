package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.service.TransactionService;
import com.example.demo.service.TransactionServiceImpli;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/finance/transactions")
@Tag(name = "Transaction Details" , description = "All Transaction related operations performed")
public class TransactionController {

	@Autowired
	
	private TransactionServiceImpli transactionservice;
	
	@PostMapping
	@Operation(summary = "Create New Transaction")
	@ApiResponse(responseCode = "201" , description = "Transaction Created")
	@ApiResponse(responseCode = "400" , description = "Validation Field")
	@ApiResponse(responseCode = "404" , description = "Account Not Found")
	public ResponseEntity<TransactionResponse> createTransaction(@Valid @RequestBody TransactionRequest request){
		
		TransactionResponse response = transactionservice.createTransaction(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping("/account/{accountId}")
	@Operation(summary = "Transactions By Account" , description = "All transactions Done by an particular Account")
	@ApiResponse(responseCode = "202" , description = "Transactions fetched")
	public ResponseEntity<List<TransactionResponse>> getTransactionsByAccount(@PathVariable Long accountId){
		
		List<TransactionResponse> transactions = transactionservice.getTransactionsByAccountId(accountId);
		return ResponseEntity.ok(transactions);
	}
	
	@GetMapping("/date/{date}")
	@Operation(summary = "Transactions in a Date" , description = "All transactions on a Particular Date")
	@ApiResponse(responseCode = "202" , description = "Transactions fetched")
	public ResponseEntity<List<TransactionResponse>> getTransactionsByDate(@PathVariable @DateTimeFormat LocalDate date){
		
		List<TransactionResponse> transactions = transactionservice.getTransactionsByDate(date);
		
		return ResponseEntity.ok(transactions);
		
	}
	
	@GetMapping("/customer/{customerId}")
	@Operation(summary = "Transactions By Customer" , description = "All transactions by an customer")
	@ApiResponse(responseCode = "202" , description = "Transactions fetched")
	public ResponseEntity<Page<TransactionResponse>> getTransactionByCustomer(@PathVariable Long customerId , @RequestParam(defaultValue = "0") int page ,
																											@RequestParam(defaultValue = "3") int size){
		
		Page<TransactionResponse> transactions = transactionservice.getTransactionsByCustomerId(customerId, page, size);
		return ResponseEntity.ok(transactions);
 	}
}
