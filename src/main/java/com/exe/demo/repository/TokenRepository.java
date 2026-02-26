package com.exe.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exe.demo.model.ServiceEntity;
import com.exe.demo.model.Token;


public interface TokenRepository extends JpaRepository<Token ,Long> {

List<Token> findByServiceAndStatus(ServiceEntity service, String status);
Optional<Token> findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(
        ServiceEntity service,
        String status,
        String priorityType
);

List<Token> findByStatus(String status);
}
