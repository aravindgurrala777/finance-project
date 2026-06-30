package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.CreateAccount;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.entity.Account;

public interface AccountService {

	
    public ResponseEntity<?> createOrUpdateAccount(CreateAccount accountdto);
	
	
	public Page<AccountResponse> getAllAccount(int page , int size);
	
	public ResponseEntity<?> getAccountById(Long accountId);
	
	
	public ResponseEntity<?> deleteAccount(Long accountId);
	
	
}
