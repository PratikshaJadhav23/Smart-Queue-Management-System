package com.exe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.demo.model.Counter;
import com.exe.demo.model.ServiceEntity;
import com.exe.demo.repository.CounterRepository;
import com.exe.demo.repository.ServiceRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/counters")
public class CounterController {
	@Autowired
	private CounterRepository counterRepository;
	
	@Autowired 
	private ServiceRepository serviceRepository;
	
	@GetMapping
    public String listCounters(Model model, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("counters", counterRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());

        return "counterList";
    }

	
	@PostMapping("/add")
    public String addCounter(@RequestParam String counterName,
                             @RequestParam Long serviceId,
                             HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);

        if (service != null) {
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setService(service);
            counter.setStatus("OPEN");
            counterRepository.save(counter);
        }

        return "redirect:/admin/counters";
    }
	
	
	 @GetMapping("/toggle/{id}")
	    public String toggleCounter(@PathVariable Long id,
	                                HttpSession session) {

	        if (session.getAttribute("admin") == null) {
	            return "redirect:/admin/login";
	        }

	        Counter counter = counterRepository.findById(id).orElse(null);

	        if (counter != null) {
	            if (counter.getStatus().equals("OPEN")) {
	                counter.setStatus("CLOSED");
	            } else {
	                counter.setStatus("OPEN");
	            }
	            counterRepository.save(counter);
	        }

	        return "redirect:/admin/counters";
	    }
}
