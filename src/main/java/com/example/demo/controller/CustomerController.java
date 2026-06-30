package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CreateCustomer;
import com.example.demo.dto.response.CustomerResponse;
import com.example.demo.service.CustomerServiceImpli;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/finance/customers")
@Validated
@Tag(name = "CUSTOMER API" , description = " All Customer Details Tracking Logs ")
public class CustomerController {

	@Autowired
	private CustomerServiceImpli customerservice;
	
	@PostMapping()
	@Operation(summary = "Add an Customer" , description = "Creates and registers the details of an Customer")
	@ApiResponse(responseCode = "201" , description = "Customer Added Successfully")
	public ResponseEntity<?> createCustomer(@RequestBody CreateCustomer customerdto){
		
		return customerservice.createCustomer(customerdto);
	}
	
	@GetMapping()
	@Operation(summary = "Fetch Customers" , description = "Shows the registered customers")
	@ApiResponse(responseCode = "202" , description = "Customers Fetched Successfully")
	public ResponseEntity<Page<CustomerResponse>> getAllCustomer( @RequestParam(defaultValue = "0") @Min(0) int page ,
																  @RequestParam(defaultValue = "10") @Min(1)  int size	){
		
		Page<CustomerResponse> customers = customerservice.getAllCustomer(page, size);
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{customerId}")
	@Operation(summary = "Fetch Customer By Id" , description = "Shows the single customer")
	@ApiResponse(responseCode = "202" , description = "Customer Fetched Successfully")
	public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
		   CustomerResponse customer =customerservice.getCustomerById(customerId);
		return ResponseEntity.ok(customer) ;
	}
	
	@PutMapping("/{customerId}")
	@Operation(summary = "Updates Customer" , description = "Updates the details of the Customers")
	@ApiResponse(responseCode = "203" , description = "Customer Updated Successfully")
	public ResponseEntity<?> updateCustomer(@PathVariable Long customerId,@Valid @RequestBody CreateCustomer customerdto) {
		
		return customerservice.updateCustomer(customerId, customerdto);
	}
	
	@DeleteMapping("/delete/{customerId}")
	@Operation(summary = "DeRegister Customer" , description = "Deletes the Customers details Completely")
	@ApiResponse(responseCode = "204" , description = "Customer Deleted Successfully")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
		
		return customerservice.deleteCustomer(customerId);
	}
}
