package com.exe.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.demo.model.ServiceEntity;
import com.exe.demo.repository.ServiceRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/services")
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository ;
	
	@GetMapping
	public String listServices(Model model,HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/admin/login";
		}
		List<ServiceEntity> services = serviceRepository.findAll();
		model.addAttribute("services",services);
		return "serviceList";
		}
	// Show add form
    @GetMapping("/add")
    public String showAddForm(HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        return "serviceAdd";
    }
    
 // Save service
    @PostMapping("/add")
    public String addService(@RequestParam String serviceName,
                             @RequestParam String serviceCode,
                             @RequestParam Integer avgServiceTime,
                             HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        ServiceEntity service = new ServiceEntity();
        service.setServiceName(serviceName);
        service.setServiceCode(serviceCode);
        service.setAvgServiceTime(avgServiceTime);
        service.setStatus(true);

        serviceRepository.save(service);

        return "redirect:/admin/services";
    }
    
    // Toggle status
    @GetMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable Long id, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        ServiceEntity service = serviceRepository.findById(id).orElse(null);

        if (service != null) {
            service.setStatus(!service.getStatus());
            serviceRepository.save(service);
        }

        return "redirect:/admin/services";
    }

}
