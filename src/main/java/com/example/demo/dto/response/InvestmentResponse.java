package com.example.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InvestmentResponse {

	
	private Long id;
	private Long customerId;
	private String customerName;
	private String investmentType;
	private BigDecimal amount;
	private LocalDate startDate;
	private LocalDate maturityDate;
	private String status;
	private LocalDateTime createdDate;
	
}
