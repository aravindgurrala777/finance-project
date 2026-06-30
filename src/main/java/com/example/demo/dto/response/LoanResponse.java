package com.example.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanResponse {

	
	private Long id;
	private Long customerId;
	private String customerName;
	private String loanType;
	private BigDecimal principalAmount;
	private BigDecimal interestRate;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoanResponse(Long id, Long customerId, String customerName, String loanType, BigDecimal principalAmount,
			BigDecimal interestRate, LocalDate startDate, LocalDate endDate, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.loanType = loanType;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	public LoanResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
