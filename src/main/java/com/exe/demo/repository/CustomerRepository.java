package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);
}