package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CreateAccount;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.service.AccountServiceImpli;
import com.example.demo.service.CustomerServiceImpli;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/finance")
@Tag(name = "Accounts API" , description = "Account Details Of an Customer")
public class AccountController {

	@Autowired
	CustomerServiceImpli customerservice;
	
	@Autowired
	AccountServiceImpli accountservice;
	
	@PostMapping("/accounts/account")
	@Operation(summary = "Create or Update Account Details" , description = "Customer Account details are created or updated...")
	@ApiResponse(responseCode = "201" , description = "Account Updated Successfully")
	public ResponseEntity<?> createOrUpdateAccount(@RequestBody CreateAccount accountdto){
		
		
		return accountservice.createOrUpdateAccount(accountdto);
	}
	
	@GetMapping("/accounts")
	@Operation(summary = "Fetch Accounts" , description = " Fetch all Account Details")
	@ApiResponse(responseCode = "202" , description = "Accounts Fetched Successfully")
	public ResponseEntity<Page<AccountResponse>> getAllAccount( @RequestParam(defaultValue = "0" )int page ,
																@RequestParam(defaultValue = "3") int size){
		
		Page<AccountResponse> accounts = accountservice.getAllAccount(page, size);
		
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/accounts/{accountId}")
	@Operation(summary = "Fetch Single Account" , description = "Fetches the single account by Id")
	@ApiResponse(responseCode = "202" , description = "Account Fetched Successfully")
	public ResponseEntity<?> getAccountById(@PathVariable Long accountId){
		
		return accountservice.getAccountById(accountId);
	}
	
	@DeleteMapping("/accounts/delete/{accountId}")
	@Operation(summary = "Delete Account" , description = "Deletes the Account of an customer by Id")
	@ApiResponse(responseCode = "204" , description = "Account Deleted Successfully")
	public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
		
		return accountservice.deleteAccount(accountId);
	}
}
