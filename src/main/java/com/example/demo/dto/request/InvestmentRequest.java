package com.example.demo.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentRequest {

	@NotNull(message = "Customer Id is required")
	private Long customerId;
	
	@NotBlank(message = "Investment Type is required")
	private String investmentType;
	
	@NotNull(message = "Amount is required")
	@DecimalMin(value = "1000" , message = "Minimum investment amount is 1000")
	private BigDecimal amount;
	
	@NotNull(message = "StartDate is required")
	private LocalDate startDate;
	
	
	private LocalDate maturityDate;
	
	
}
