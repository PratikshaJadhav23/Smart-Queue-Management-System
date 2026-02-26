package com.exe.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exe.demo.model.ServiceEntity;

public interface ServiceRepository  extends JpaRepository<ServiceEntity,Long>{
	List<ServiceEntity> findByStatusTrue();
}
