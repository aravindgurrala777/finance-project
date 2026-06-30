package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId")
	
	private Long accountId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	@JsonBackReference
	private Customer customer;
	
	@OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();
	
	
	
	@Column(name = "accountNumber")
	private String accountNumber;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@Column(name = "status")
	private String status;;
	
	@CreatedDate
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	@Column(name = "createdAt")
	private LocalDate createdAt;
	
	@LastModifiedDate
	@Column(name = "modifiedDate")
	private LocalDate modifiedDate;
	
	@Version
	@Column(name = "version")
	private Long version;
	
	

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Account(Long accountId, Customer customer, String accountNumber, String accountType, BigDecimal balance,
			String status, LocalDate createdAt , LocalDate modifiedDate , Long version) {
		super();
		this.accountId = accountId;
		this.customer = customer;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedDate = modifiedDate;
		this.version  = version ;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customer=" + customer + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", balance=" + balance + ", status=" + status + ", createdAt="
				+ createdAt + "]";
	}
	
	
	
}
