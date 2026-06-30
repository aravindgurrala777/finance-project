package com.example.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enums.TransactionType;

public class TransactionResponse {

	
	private Long transactionId;
	private TransactionType transactionType;
	private BigDecimal amount;
	private LocalDateTime transactionDate;
	private String description;
	private Long accountId;
	private String accountNumber;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private Long version;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
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
	
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public TransactionResponse(Long transactionId, TransactionType transactionType, BigDecimal amount, LocalDateTime transactionDate,
			String description, Long accountId, String accountNumber,LocalDateTime createdDate , LocalDateTime modifiedDate, Long version) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.version = version;
	}
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
