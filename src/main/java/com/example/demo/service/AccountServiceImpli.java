package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.CreateAccount;
import com.example.demo.dto.request.CreateCustomer;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class AccountServiceImpli implements AccountService {

	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpli.class);
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private AccountRepository accountrepository;
	
	@Transactional
	@jakarta.transaction.Transactional(rollbackOn = Exception.class)
	public ResponseEntity<?> createOrUpdateAccount(CreateAccount accountdto){
		
		
		
		Long accountId = accountdto.getAccountId();
		
		if(accountId != null) {
			
			Optional<Account> exist = accountrepository.findById(accountId);
			
			if(exist.isPresent()) {
				
				logger.info("Account Details Updating Started");
				
				Account account = exist.get();
				
				account.setAccountType(accountdto.getAccountType());
				account.setBalance(accountdto.getBalance());
				account.setStatus(accountdto.getStatus());
				
				accountrepository.save(account);
				
				logger.info("Account Details Updated Successfullyy");
				
				return ResponseEntity.ok("Account Details Updated Successfully...");
			 }
			
			logger.info("Account Details not founded in records");
					return ResponseEntity.badRequest().body("Account Not Found...");
	}
		
		logger.info("Account Creation Process Started..");
		
		Account account = new Account();
		
		account.setAccountNumber(accountdto.getAccountNumber());
		account.setAccountType(accountdto.getAccountType());
		account.setBalance(accountdto.getBalance());
		account.setStatus("PENDING");
		account.setCreatedAt(LocalDate.now());
		account.setModifiedDate(LocalDate.now());
		account.setVersion(accountdto.getVersion());
		
		
		Customer customer = customerrepository.findById(accountdto.getCustomerId()).orElseThrow();
		
		account.setCustomer(customer);
		
		customer.getAccounts().add(account);
		
		accountrepository.save(account);
		
		logger.info("Account Creation for the Customer Processed Successfullyy.." );
		
		return ResponseEntity.ok("Account Created Successfullyy...");
	}


	@Override
	public Page<AccountResponse> getAllAccount(int page, int size) {

		logger.info("Account Details Fetching....");
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> accountsPage = accountrepository.findAll(pageable);
		
		logger.info("Mapping account entity details to response dto");
		return accountsPage.map(this::toResponse) ;
		
	}


	@Override
	public ResponseEntity<?> getAccountById(Long accountId) {

		logger.info("Account Fetched By ID ....");
		return ResponseEntity.ok(accountrepository.findById(accountId));
		
	}


	@Override
	public ResponseEntity<?> deleteAccount(Long accountId) {

		accountrepository.deleteById(accountId);
		
		logger.info("Account Deleted Successfullyy...");
		return ResponseEntity.ok("Account Deleted Successfullyy..");
	}


	private AccountResponse toResponse(Account account) {
		AccountResponse dto = new AccountResponse();
		dto.setAccountId(account.getAccountId());
		dto.setAccountNumber(account.getAccountNumber());
		dto.setAccountType(account.getAccountType());
		dto.setBalance(account.getBalance());
		dto.setStatus(account.getStatus());
		dto.setCreatedAt(account.getCreatedAt());
		dto.setModifiedDate(account.getModifiedDate());
		dto.setVersion(account.getVersion());
		
		if(account.getCustomer() != null) {
			dto.setCustomerId(account.getCustomer().getCustomerId());
			dto.setCustomerName(account.getCustomer().getName());
			dto.setCustomerEmail(account.getCustomer().getEmail());
			
		}
		
		logger.info("Details Fetched Successfully..");
		return dto;
	}
	

	
	
}














