package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.TransactionRequest;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.exception.InsufficientBalanceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionRepository;

import jakarta.transaction.Transactional;


@Service
public class TransactionServiceImpli implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpli.class);
	
	@Autowired
	private TransactionRepository transactionrepository;
	@Autowired
	private AccountRepository accountrepository;
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Override
	@Transactional
	public TransactionResponse createTransaction(TransactionRequest request) {

		 logger.info("Transaction Initiated ... ");
		
		Account account = accountrepository.findById(request.getAccountId())
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found with id: " + request.getAccountId()));
		
				logger.info("Validating the status of Account ...");
				if(!"CREATED".equalsIgnoreCase(account.getStatus())) {
					throw new IllegalStateException("Account not created. Current status: " + account.getStatus());
				}
				
				
				BigDecimal amount = request.getAmount();
				
				
				if("WITHDRAWAL".equals(request.getTransactionType())) {
					
					logger.info("Checking Amount is grater than 0 or not");
					if(account.getBalance().compareTo(amount) < 0) {
						throw new InsufficientBalanceException("Insufficient balance. Avaliable Balance: " + account.getBalance());
					}
					logger.info("Processing Withdrawal Transaction");
					account.setBalance(account.getBalance().subtract(amount));
				} else if("DEPOSIT".equals(request.getTransactionType())) {
					
					logger.info("Processing Deposit Transaction");
					account.setBalance(account.getBalance().add(amount));
					
				}
				
				accountrepository.save(account);
				
				Transaction transaction = new Transaction();
				transaction.setTransactionType(request.getTransactionType());
				transaction.setAmount(amount);
				transaction.setDescription(request.getDescription());
				transaction.setAccount(account);
				
				logger.info("Transaction Processed Successfullyy");
				Transaction saved = transactionrepository.save(transaction);
				
				return toResponse(saved);
				
	}

	

	@Override
	public List<TransactionResponse> getTransactionsByAccountId(Long accountId) {

		logger.info("Transactions by Account " + accountId + " details Loading");
		if(!accountrepository.existsById(accountId)) {
			throw new ResourceNotFoundException("Account not found with id: " + accountId);
		}
		
		List<Transaction> transaction = transactionrepository.findByAccountAccountIdOrderByTransactionDateDesc(accountId);
		return transaction.stream().map(this::toResponse).collect(Collectors.toList());
				
		
	}

	@Override
	public List getTransactionsByDate(LocalDate date) {

		logger.info("Transaction in date " + date + " is loading");
		List<Transaction> transactions = transactionrepository.findByTransactionDate(date);
		return transactions.stream().map(this::toResponse).collect(Collectors.toList());
		
	}

	@Override
	public Page<TransactionResponse> getTransactionsByCustomerId(Long customerId, int page, int size) {

	logger.info("Transactions by CustomerId" + customerId + " details loading");
		if(!customerrepository.existsById(customerId)) {
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}
		
	
		Pageable pageable = PageRequest.of(page, size, Sort.by("transactionDate").descending());
		Page<Transaction> transactions = transactionrepository.findByCustomerId(customerId, pageable);
		return transactions.map(this::toResponse);
		
	}

	private TransactionResponse toResponse(Transaction t) {
		TransactionResponse dto = new TransactionResponse();
		
		dto.setTransactionId(t.getTransactionId());
		dto.setTransactionType(t.getTransactionType());
		dto.setAmount(t.getAmount());
		dto.setTransactionDate(t.getTransactionDate());
		dto.setDescription(t.getDescription());
		dto.setAccountId(t.getAccount().getAccountId());
		dto.setAccountNumber(t.getAccount().getAccountNumber());
		dto.setCreatedDate(t.getCreatedDate());
		dto.setModifiedDate(t.getModifiedDate());
		dto.setVersion(t.getVersion());
		
		return dto;
		
	}
	
	
	
	
}
