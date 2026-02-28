package com.exe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.demo.model.Counter;
import com.exe.demo.model.ServiceEntity;
import com.exe.demo.model.Token;
import com.exe.demo.model.User;
import com.exe.demo.repository.CounterRepository;
import com.exe.demo.repository.ServiceRepository;
import com.exe.demo.repository.TokenRepository;
import com.exe.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class adminController {
	@Autowired
	private CounterRepository counterRepository;
	
	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	 @GetMapping("/")
	    public String homePage(Model model) {

	        model.addAttribute("services", serviceRepository.findByStatusTrue());

	        return "index";   // index.html
	    }
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
    public String dashboard(HttpSession session,Model model) {
    	
    	long total = tokenRepository.count();
    	long waiting = tokenRepository.countByStatus("WAITING");
    	long called = tokenRepository.countByStatus("CALLED");
    	long completed = tokenRepository.countByStatus("COMPLETED");

    	model.addAttribute("total", total);
    	model.addAttribute("waiting", waiting);
    	model.addAttribute("called", called);
    	model.addAttribute("completed", completed);

    	if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("services", serviceRepository.findAll());

        return "adminDashboard";
    }

    // Logout
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
    
    
    @GetMapping("/admin/call-next/{serviceId}")
    public String callNextToken(@PathVariable Long serviceId,
                                HttpSession session,
                                Model model) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);

        if (service == null) {
            return "redirect:/adminDashboard";
        }

        Token nextToken = null;

        // Priority 1: DISABLED
        nextToken = tokenRepository
                .findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(
                        service, "WAITING", "DISABLED")
                .orElse(null);

        // Priority 2: SENIOR
        if (nextToken == null) {
            nextToken = tokenRepository
                    .findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(
                            service, "WAITING", "SENIOR")
                    .orElse(null);
        }

        // Priority 3: NORMAL
        if (nextToken == null) {
            nextToken = tokenRepository
                    .findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(
                            service, "WAITING", "NORMAL")
                    .orElse(null);
        }
        if (nextToken != null) {

            // Find available OPEN counter for this service
            Counter counter = counterRepository
                    .findFirstByServiceAndStatus(service, "OPEN")
                    .orElse(null);

            if (counter != null) {
                nextToken.setStatus("CALLED");
                nextToken.setCounter(counter);  // Assign counter
                tokenRepository.save(nextToken);

                model.addAttribute("calledToken", nextToken);
                model.addAttribute("counterName", counter.getCounterName());
            } else {
                model.addAttribute("message", "No open counter available.");
            }

        } else {
            model.addAttribute("message", "No tokens in queue.");
        }
        model.addAttribute("service", service);
        return "callResult";
    }
    
    @GetMapping("/call/{serviceId}")
    public String callNextToken(@PathVariable Long serviceId, Model model) {

        ServiceEntity service = serviceRepository
                .findById(serviceId)
                .orElse(null);

        // First call SENIOR
        Token nextToken = tokenRepository
                .findTopByServiceAndStatusAndPriorityTypeOrderByIdAsc(
                        service, "WAITING", "SENIOR");

        // If no senior, call NORMAL
        if (nextToken == null) {
            nextToken = tokenRepository
                    .findTopByServiceAndStatusAndPriorityTypeOrderByIdAsc(
                            service, "WAITING", "NORMAL");
        }

        if (nextToken != null) {
            nextToken.setStatus("CALLED");
            tokenRepository.save(nextToken);
        }

        return "adminDashboard";
    }
    
    @GetMapping("/complete/{id}")
    public String completeToken(@PathVariable Long id) {

        Token token = tokenRepository.findById(id).orElse(null);

        if (token != null) {
            token.setStatus("COMPLETED");
            tokenRepository.save(token);
        }

        return "redirect:/admin/dashboard";
    }
}
