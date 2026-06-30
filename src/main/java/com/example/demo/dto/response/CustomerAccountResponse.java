package com.example.demo.dto.response;

import java.time.LocalDate;

//Separate RESPONSE DTO to show only limited account details through customer details...

public class CustomerAccountResponse {

	private Long accountId;
	private String accountType;
	private String status;
	private LocalDate createdAt;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	public CustomerAccountResponse(Long accountId, String accountType, String status, LocalDate createdAt) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.status = status;
		this.createdAt = createdAt;
	}
	public CustomerAccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerAccountResponse [accountId=" + accountId + ", accountType=" + accountType + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
