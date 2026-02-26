package com.exe.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tokenNumber;
	private String citizenName;
	private String mobile;
	private String priorityType;  //NORMAL,SENIOR,DISABLED
	private String status;    //WAITING ,CALLED,COMPLETED
	private LocalDateTime createdTime;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private ServiceEntity service;
	
	@ManyToOne
	@JoinColumn(name = "counter_id")
	private Counter counter;

	private Integer counterNumber;
	public Token() {
		this.createdTime = LocalDateTime.now();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPriorityType() {
		return priorityType;
	}
	public void setPriorityType(String priorityType) {
		this.priorityType = priorityType;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public ServiceEntity getService() {
		return service;
	}
	public void setService(ServiceEntity service) {
		this.service = service;
	}
	public Counter getCounter() {
		return counter;
	}
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	public Integer getCounterNumber() {
		return counterNumber;
	}
	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}
	

}
