package com.example.demo.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAccount {

	@NotNull(message = "CustomerId is required")
	private Long customerId;
	
	private Long accountId;
	
	@NotBlank
	private String accountNumber;
	
	@NotBlank
	private String accountType;
	
	@DecimalMin(value = "0")
	private BigDecimal balance;

	private String status;
	
	private LocalDate createdAt;
	
	private LocalDate modifiedDate;
	
	private Long version ;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	
	
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public CreateAccount(@NotNull(message = "CustomerId is required") Long customerId, Long accountId,
			@NotBlank String accountNumber, @NotBlank String accountType, @DecimalMin("0") BigDecimal balance,
			String status, LocalDate createdAt , LocalDate modifiedDate , Long version) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.createdAt = createdAt;
	}

	public CreateAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CreateAccount [customerId=" + customerId + ", accountId=" + accountId + ", accountNumber="
				+ accountNumber + ", accountType=" + accountType + ", balance=" + balance + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
	
	
}
