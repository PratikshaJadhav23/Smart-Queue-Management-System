package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exe.demo.model.ServiceEntity;

public interface ServiceRepository  extends JpaRepository<ServiceEntity,Long>{

}
