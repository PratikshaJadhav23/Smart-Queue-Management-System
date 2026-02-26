package com.exe.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer tokenNumber;
	private String citizenName;
	private String mobile;
	private String priorityType;  //NORMAL,SENIOR,DISABLED
	private String Status;    //WAITING ,CALLED,COMPLETED
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
