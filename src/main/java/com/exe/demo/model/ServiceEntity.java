package com.exe.demo.model;

import jakarta.persistence.*;

@Entity
public class ServiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String serviceName;
	private String serviceCode;
	private Integer avgServiceTime;
	
	private Boolean status;

	public ServiceEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Integer getAvgServiceTime() {
		return avgServiceTime;
	}

	public void setAvgServiceTime(Integer avgServiceTime) {
		this.avgServiceTime = avgServiceTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
