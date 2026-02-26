package com.exe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.demo.model.User;
import com.exe.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class adminController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/admin/login")
	private String showLogin() {
		return "adminLogin";
	}
	
	@PostMapping("/admin/login")
	private String login(@RequestParam String username,
			@RequestParam String password,
			HttpSession session,
			Model model) {
		User user = userRepository.findByUsername(username);
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("admin", user);
			return "redirect:/adminDashboard";
		}
		model.addAttribute("error","Invalid Username or Password");
		return "adminLogin";
	}
	
	// Dashboard
    @GetMapping("/adminDashboard")
    public String dashboard(HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        return "adminDashboard";
    }

    // Logout
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

}
