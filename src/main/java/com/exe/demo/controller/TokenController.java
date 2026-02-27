package com.exe.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exe.demo.model.ServiceEntity;
import com.exe.demo.model.Token;
import com.exe.demo.repository.ServiceRepository;
import com.exe.demo.repository.TokenRepository;

@Controller
public class TokenController {
	@Autowired
	private ServiceRepository serviceRepository ;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@GetMapping("/token")
	public String showTokenForm(Model model) {
		model.addAttribute("services", serviceRepository.findByStatusTrue());
		return "tokenForm";
	}
	
	//Generated token 
	@PostMapping("/token")
	public String generateToken(@RequestParam String citizenName,
            @RequestParam String mobile,
            @RequestParam Long serviceId,
            @RequestParam String priorityType,
            Model model){
		ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);
		if(service == null) {
			model.addAttribute("error","Invalid Services");
			return "tokenForm";
		}
		
		 // Count existing WAITING tokens
        List<Token> waitingTokens =
                tokenRepository.findByServiceAndStatus(service, "WAITING");

        int tokenCount = waitingTokens.size() + 1;

        String tokenNumber = service.getServiceCode() + "-" +
                String.format("%03d", tokenCount);

        // Create token
        Token token = new Token();
        token.setCitizenName(citizenName);
        token.setMobile(mobile);
        token.setPriorityType(priorityType);
        token.setService(service);
        token.setStatus("WAITING");
        token.setTokenNumber(tokenNumber);
        token.setCreatedTime(LocalDateTime.now());

        tokenRepository.save(token);

        // Calculate waiting time
        int estimatedTime = waitingTokens.size() * service.getAvgServiceTime();

        model.addAttribute("tokenNumber", tokenNumber);
        model.addAttribute("estimatedTime", estimatedTime);

        return "tokenSuccess";
        
	}
	
}
