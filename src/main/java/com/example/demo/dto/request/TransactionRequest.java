package com.example.demo.dto.request;

import java.math.BigDecimal;

import com.example.demo.enums.TransactionType;

import jakarta.validation.constraints.NotNull;

public class TransactionRequest {

	@NotNull(message = "Account ID is required")
	private Long accountId;
	
	@NotNull(message = "Trasaction Type is required")
	private TransactionType transactionType;
	
	@NotNull
	private  BigDecimal amount;
	
	private String description;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public void setAmount(@NotNull BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionRequest(@NotNull(message = "Account ID is required") Long accountId,
			@NotNull(message = "Trasaction Type is required") TransactionType transactionType, @NotNull BigDecimal amount,
			String description) {
		super();
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.description = description;
	}

	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
