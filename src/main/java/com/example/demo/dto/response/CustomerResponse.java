package com.example.demo.dto.response;

import java.time.LocalDate;
import java.util.List;

public class CustomerResponse {

	private Long customerId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private LocalDate createdAt;
	private LocalDate modifiedDate;
	private Long version;
	
	private List<CustomerAccountResponse> accounts;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public List<CustomerAccountResponse> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CustomerAccountResponse> accounts) {
		this.accounts = accounts;
	}

	public CustomerResponse(Long customerId, String name, String email, String phone, String address, LocalDate createdAt, LocalDate modifiedDate , Long version ,
			List<CustomerAccountResponse> accounts) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.createdAt = createdAt;
		this.modifiedDate = modifiedDate;
		this.version = version;
		this.accounts = accounts;
	}

	public CustomerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerResponse [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", createdAt=" + createdAt + ", modifiedDate=" + modifiedDate + ", version="
				+ version + ", accounts=" + accounts + "]";
	}

	
	
	
}
