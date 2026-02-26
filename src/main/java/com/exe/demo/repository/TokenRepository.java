package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.demo.model.Token;


public interface TokenRepository extends JpaRepository<Token ,Long> {

}
