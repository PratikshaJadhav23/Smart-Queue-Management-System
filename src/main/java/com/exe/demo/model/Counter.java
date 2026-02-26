package com.exe.demo.model;

import jakarta.persistence.*;

@Entity
public class Counter {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String counterName;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private ServiceEntity service;
	private String status;
	public Counter() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public ServiceEntity getService() {
		return service;
	}
	public void setService(ServiceEntity service) {
		this.service = service;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	 

}
