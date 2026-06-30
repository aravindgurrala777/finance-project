package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId" , nullable = false)
	@JsonBackReference
	private Customer customer;
	
	@Column(name = "loanType" , nullable = false)
	private String loanType;
	
	@Column(name = "principalAmount" , nullable = false )
	private BigDecimal principalAmount;
	
	@Column(name = "interestRate" , nullable = false)
	private BigDecimal interestRate;
	
	@Column(name = "startDate" , nullable = false)
	private LocalDate startDate;
	
	@Column(name = "endDate" , nullable = false)
	private LocalDate endDate;
	
	@Column(name = "status" , nullable = false)
	private String status;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt = LocalDateTime.now();

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Loan(Long loanId, Customer customer, String loanType, BigDecimal principalAmount, BigDecimal interestRate,
			LocalDate startDate, LocalDate endDate, String status, LocalDateTime createdAt) {
		super();
		this.loanId = loanId;
		this.customer = customer;
		this.loanType = loanType;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
