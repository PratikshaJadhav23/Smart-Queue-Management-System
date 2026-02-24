package com.exe.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exe.demo.model.Officer;

public interface OfficerRepository  extends JpaRepository<Officer,Long>{
	Optional<Officer> findByEmployeeId(String employeeId);
}
