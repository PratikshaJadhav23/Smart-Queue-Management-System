package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exe.demo.model.Service;

public interface ServiceRepository  extends JpaRepository<Service,Long>{

}
