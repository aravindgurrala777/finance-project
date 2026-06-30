package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.CreateCustomer;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.dto.response.CustomerAccountResponse;
import com.example.demo.dto.response.CustomerResponse;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;



@Service
public class CustomerServiceImpli implements CustomerService{
	
	@Autowired
	CustomerRepository customerrepository;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerServiceImpli.class);

	
	public ResponseEntity<?> createCustomer(CreateCustomer customerdto) {
		
		logger.info("Customer Adding process Started");
		
		Customer customer = new Customer();
		
		customer.setName(customerdto.getName());
		customer.setEmail(customerdto.getEmail());
		customer.setPhone(customerdto.getPhone());
		customer.setAddress(customerdto.getAddress());
		customer.setCreatedAt(LocalDate.now());
	
		
		customerrepository.save(customer);
		
		logger.info("Customer Registered Successfullyy");
		
		return ResponseEntity.ok("Customer Addess Successfullyy..");
		
	}

	
	public Page<CustomerResponse> getAllCustomer(int page , int size) {

		logger.info("Customer Details Fetching..");
		Pageable pageable = PageRequest.of(page, size , Sort.by("id").ascending());
		Page<Customer> customersPage = customerrepository.findAllWithAccounts(pageable);
		
		logger.info("Customer Details Fetched Successfullyy..");
		return customersPage.map(this::toResponse);
		
	}

	
	public CustomerResponse getCustomerById(Long customerId) {
		
		Customer customer = customerrepository.findByIdWithAccounts(customerId).
				orElseThrow() ;
				
				logger.info("Customer Details fetched by Id");
      return toResponse(customer);
		
	}

	@Transactional
	public ResponseEntity<?> updateCustomer(Long customerId, CreateCustomer customerdto) {
		
		logger.info("Updating customer id: {}" ,customerId);
		
		Optional<Customer> exist = customerrepository.findById(customerId);
		
		if(exist.isPresent()) {
			
			logger.info("Customer Details updating started...");
			Customer customer = exist.get();
			
			customer.setName(customerdto.getName());
			customer.setEmail(customerdto.getEmail());
			customer.setPhone(customerdto.getPhone());
			customer.setAddress(customerdto.getAddress());
            
			
			customerrepository.save(customer);
			
			logger.info("Customer details Updated Successfully...");
			return ResponseEntity.ok("Customer Updated Successfullyy..");
		}
		
		logger.info("Customer not found with Id...");
		return ResponseEntity.badRequest().body("Customer Not found..");
	}

	
	public ResponseEntity<?> deleteCustomer(Long customerId) {
		
		customerrepository.deleteById(customerId);
		
		logger.info("Custtomer Deleted Successfully...");
		return ResponseEntity.ok("Customer Deleted Successfullyy..");
	}

	
	private CustomerResponse toResponse(Customer customer) {
		
		CustomerResponse dto = new CustomerResponse();
		dto.setCustomerId(customer.getCustomerId());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setPhone(customer.getPhone());
		dto.setAddress(customer.getAddress());
		dto.setCreatedAt(customer.getCreatedAt());
		dto.setModifiedDate(customer.getModifiedDate());
		dto.setVersion(customer.getVersion());
		
		
		if(customer.getAccounts() != null && !customer.getAccounts().isEmpty()) {
			
			List<CustomerAccountResponse> accountsdto = customer.getAccounts().stream().map(account -> {
				
				 CustomerAccountResponse accdto = new CustomerAccountResponse();
				 accdto.setAccountId(account.getAccountId());
	//			 accdto.setAccountNumber(account.getAccountNumber());  //Hiding account details by creating separate response dto
				 accdto.setAccountType(account.getAccountType());
//				 accdto.setBalance(account.getBalance());
			     accdto.setStatus(account.getStatus());
				 accdto.setCreatedAt(account.getCreatedAt());
				 
				
				 
				 return accdto;
			}).collect(Collectors.toList());
			dto.setAccounts(accountsdto);
				
			
		}
		
		
		return dto ;
		
	}
	
}






