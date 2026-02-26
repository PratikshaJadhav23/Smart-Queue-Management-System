//package com.exe.demo.controller;
//
//import java.util.Optional;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.exe.demo.repository.UserRepository;
//import com.exe.demo.repository.CounterRepository;
//
//@Controller
//public class AuthController {
//	private final UserRepository customerRepository;
//	private final CounterRepository officerRepository;
//	
//	public AuthController(UserRepository customerRepository,CounterRepository officerRepository) {
//		this.customerRepository = customerRepository ;
//		this.officerRepository = officerRepository;
//	}
//	//CUSTOMER REGISTER
//	@GetMapping("/register")
//	public String showRegisterForm(Model model) {
//	    model.addAttribute("customer", new Customer());
//	    return "customerRegister";
//	}
//	@PostMapping("/register")
//	public String registerCustomer(@ModelAttribute Customer customer) {
//	    customerRepository.save(customer);
//	    return "customerLogin";
//	}
//	//CUSTOMER LOGIN 
//	@GetMapping("/login")
//	public String showCustomerLogin() {
//	    return "customerLogin";
//	}
//	@PostMapping("/login")
//	public String loginCustomer(@RequestParam String email,
//	                            @RequestParam String password,
//	                            Model model) {
//
//	    Optional<Customer> customer = customerRepository.findByEmail(email);
//
//	    if (customer.isPresent() &&
//	        customer.get().getPassword().equals(password)) {
//
//	        return "redirect:/customerDashboard";
//	    }
//
//	    model.addAttribute("error", "Invalid Email or Password");
//	    return "customerLogin";  // ✅ no redirect here
//	}
//	@GetMapping("/customerDashboard")
//	public String showDashboard() {
//	    return "customerDashboard";
//	}
//	
//	//OFFICER LOGIN 
//	@GetMapping("/officer-login")
//	public String showOfficerLogin() {
//	    return "officerLogin";
//	}
//	@PostMapping("/officer-login")
//	public String loginOfficer(@RequestParam("employeeId") String employeeId,
//	                           @RequestParam("password") String password,
//	                           Model model) {
//
//	    Optional<Officer> officer = officerRepository.findByEmployeeId(employeeId);
//
//	    if (officer.isPresent() &&
//	        officer.get().getPassword().equals(password)) {
//
//	        return "redirect:/officerDashboard";
//	    }
//
//	    model.addAttribute("error", "Invalid Employee ID or Password");
//	    return "officerLogin";
//	}
//	 @GetMapping("/officerDashboard")
//	    public String officerDashboard() {
//	        return "officerDashboard";
//	    }
//}
