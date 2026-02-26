package com.exe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	@GetMapping("/customerDashboard")
	public String customerDashboard() {
		return "customerDashboard";
	}
}
