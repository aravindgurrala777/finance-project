package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	@Query(value = "select distinct c from Customer c left join fetch c.accounts" ,
			countQuery = "select count(c) from Customer c")
   Page<Customer> findAllWithAccounts(Pageable pageable);
	
	@Query("select c from Customer c left join fetch c.accounts where c.id = :id")
	Optional<Customer> findByIdWithAccounts(@Param("id") Long customerId);
	
	
	
}
