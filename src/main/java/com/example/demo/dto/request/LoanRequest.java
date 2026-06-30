package com.example.demo.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoanRequest {

	@NotNull(message = "customerId is required")
	private Long customerId;
	
	@NotBlank(message = "Loan type is required" )
	private String loanType;
	
	@NotNull(message = "Principal amount is required")
	@DecimalMin(value = "1000" , message = "Minimum loan amount is 1000")
	private BigDecimal principalAmount;
	
	@NotNull(message = "Interest rate is required")
	@DecimalMin(value = "0.1" , message = "Interest Rate mus be positive")
	@DecimalMax(value = "20" , message = "Interest rate is high")
	private BigDecimal interestRate;
	
	@NotNull(message = "Start date is required")
	private LocalDate startDate;
	
	@NotNull(message = "end date is required")	
	private LocalDate endDate;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LoanRequest(@NotNull(message = "customerId is required") Long customersId,
			@NotBlank(message = "Loan type is required") String loanType,
			@NotNull(message = "Principal amount is required") @DecimalMin(value = "1000", message = "Minimum loan amount is 1000") BigDecimal principalAmount,
			@NotNull(message = "Interest rate is required") @DecimalMin(value = "0.1", message = "Interest Rate mus be positive") @DecimalMax(value = "20", message = "Interest rate is high") BigDecimal interestRate,
			@NotNull(message = "Start date is required") LocalDate startDate,
			@NotNull(message = "end date is required") LocalDate endDate) {
		super();
		this.customerId = customerId;
		this.loanType = loanType;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LoanRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
