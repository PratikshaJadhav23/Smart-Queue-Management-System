package com.exe.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="tokens")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer tokenNumber;
	private String Status;
	private LocalDateTime createdTime;
	private Integer counterNumber;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	
	public Token() {
		this.createdTime = LocalDateTime.now();
		this.Status = "WAITING";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(Integer tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
}
