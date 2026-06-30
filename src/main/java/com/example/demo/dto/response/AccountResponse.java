package com.example.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AccountResponse {

	
	private Long accountId;
	
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	private String status;
	private LocalDate createdAt;
	private LocalDate modifiedDate;
	private Long version;
	
    private Long customerId;

    private String customerName;
    
    private String customerEmail;

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

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public AccountResponse(Long accountId, String accountNumber, String accountType, BigDecimal balance, String status,
			LocalDate createdAt,LocalDate modifiedDate , Long version , Long customerId, String customerName, String customerEmail) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.createdAt = createdAt;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}

	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountResponse [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", balance=" + balance + ", status=" + status + ", createdAt=" + createdAt
				+ ", modifiedDate=" + modifiedDate + ", version=" + version + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", customerEmail=" + customerEmail + "]";
	}

	
	

	
	
}
