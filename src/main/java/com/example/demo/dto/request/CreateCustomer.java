package com.example.demo.dto.request;

import java.util.List;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateCustomer {

	@NotBlank(message = "Name is required")
	private String name;
	
	@Email(message = "Invalid email format")
	@NotBlank
	private String email;
	
	@Pattern(regexp = "[0-9]{10}" , message = "Number must be 10 digits")
	private String phone;
	
	
	private String address;

    
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


	public CreateCustomer(@NotBlank(message = "Name is required") String name,
			@Email(message = "Invalid email format") @NotBlank String email,
			@Pattern(regexp = "[0-9]{10}", message = "Number must be 10 digits") String phone, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}


	public CreateCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CreateCustomer [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
}
