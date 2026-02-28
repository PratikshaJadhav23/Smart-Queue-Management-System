package com.exe.demo.controller;

import com.exe.demo.model.Token;
import com.exe.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicController {

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/token/status")
    public String statusForm() {
        return "token-status-form";
    }

    @PostMapping("/token/status")
    public String checkStatus(@RequestParam String tokenNumber, Model model) {

        Token token = tokenRepository.findByTokenNumber(tokenNumber);
         if (tokenNumber == null || tokenNumber.isEmpty()) {
                model.addAttribute("error", "Token number cannot be empty.");
                return "token-status-form";
            }

            Token token1 = tokenRepository.findByTokenNumber(tokenNumber);

            if (token1 == null) {
                model.addAttribute("error", "Invalid Token Number.");
                return "token-status-form";
            }

            model.addAttribute("token", token1);
            return "token-status";
        }
    
}