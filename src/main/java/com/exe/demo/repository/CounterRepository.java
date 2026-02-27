package com.exe.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.demo.model.Counter;
import com.exe.demo.model.ServiceEntity;

public interface CounterRepository  extends JpaRepository<Counter,Long>{
	Optional<Counter> findFirstByServiceAndStatus(ServiceEntity service, String status);
}
