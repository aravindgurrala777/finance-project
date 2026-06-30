package com.example.demo.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.CreateCustomer;
import com.example.demo.dto.response.CustomerResponse;

public interface CustomerService {

	
	ResponseEntity<?> createCustomer(CreateCustomer customerdto);
	
	Page<CustomerResponse> getAllCustomer(int page , int size);
	
	CustomerResponse getCustomerById(Long customerId);
	
	
	ResponseEntity<?> updateCustomer(Long customerId,CreateCustomer customerdto);
	
	ResponseEntity<?> deleteCustomer(Long customerId);
}
