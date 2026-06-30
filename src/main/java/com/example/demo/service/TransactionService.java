package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.Transaction;

public interface TransactionService {

	
	public TransactionResponse createTransaction(TransactionRequest request);
	
	List<TransactionResponse> getTransactionsByAccountId(Long accountId);
	
	
	List<TransactionResponse> getTransactionsByDate( LocalDate date);
	
	
	Page<TransactionResponse> getTransactionsByCustomerId(Long customerId, int page , int size);
	
}
