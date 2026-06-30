package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "investments")
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId" , nullable = false)
	private Customer customer;
	
	@Column(name = "investmentType" , nullable = false)
	private String investmentType;
	
	@Column(name = "amount" , nullable = false )
	private BigDecimal amount;
	
	@Column(name = "startDate" , nullable = false)
	private LocalDate startDate;
	
	@Column(name = "maturityDate")
	private LocalDate maturityDate;
	
	@Column(name = "status" , nullable = false)
	private String status = "ACTIVE"; //ACTIVE,MATURED,WITHDRAWN 
	
	@CreatedDate
	@Column(name = "createdAt" , updatable = false)
	private LocalDateTime createdDate;
	
	
	
	
}
