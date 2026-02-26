package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.demo.model.Counter;

public interface CounterRepository  extends JpaRepository<Counter,Long>{
	
}
