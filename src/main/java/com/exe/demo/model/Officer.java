package com.exe.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "officers")
public class Officer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String officerNme;

	@Column(nullable = false , unique=true)
	private String employeeId;
	
	@Column(nullable = false)
	private String password;
	
	private Integer counterNumber;
	
	private String department;
	
	private LocalDateTime createdTime;

	public Officer() {
		this.createdTime = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfficerNme() {
		return officerNme;
	}

	public void setOfficerNme(String officerNme) {
		this.officerNme = officerNme;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	

	

}
