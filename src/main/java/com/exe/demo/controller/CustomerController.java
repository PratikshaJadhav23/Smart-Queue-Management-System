package com.exe.demo.controller;

import com.exe.demo.model.Customer;
import com.exe.demo.model.Token;
import com.exe.demo.repository.CustomerRepository;
import com.exe.demo.repository.ServiceRepository;
import com.exe.demo.repository.TokenRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenRepository tokenRepository;
    // ---------------- REGISTER PAGE ----------------

    @GetMapping("/customer/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerRegister";
    }

    @PostMapping("/customer/register")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {

        Customer existing = customerRepository.findByEmail(customer.getEmail());

        if (existing != null) {
            model.addAttribute("error", "Email already registered!");
            return "customerRegister";
        }

        customerRepository.save(customer);
        model.addAttribute("success", "Registration successful! Please login.");
        return "customerLogin";
    }

    // ---------------- LOGIN PAGE ----------------

    @GetMapping("/customer/login")
    public String showLoginPage() {
        return "customerLogin";
    }

    @PostMapping("/customer/login")
    public String loginCustomer(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Customer customer = customerRepository.findByEmailAndPassword(email, password);

        if (customer != null) {

            // ✅ STORE IN SESSION
            session.setAttribute("loggedInCustomer", customer);
            return "redirect:/customer/dashboard";   // create later
        } else {
            model.addAttribute("error", "Invalid Email or Password!");
            return "customerLogin";
        }
    }

    @GetMapping("/customer/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Customer customer = (Customer) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            return "redirect:/customer/login";
        }

        model.addAttribute("customer", customer);

        // ✅ VERY IMPORTANT
        List<Token> tokens = tokenRepository.findByCustomer(customer);
        model.addAttribute("tokens", tokens);

        return "customerDashboard";
    }
}