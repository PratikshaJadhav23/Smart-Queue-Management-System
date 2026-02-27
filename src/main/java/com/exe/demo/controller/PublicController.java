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

        if (token == null) {
            model.addAttribute("error", "Invalid Token Number");
            return "token-status-form";
        }

        long position = tokenRepository
                .countByStatusAndServiceIdAndIdLessThan(
                        "WAITING",
                        token.getService().getId(),
                        token.getId()
                );

        int estimatedTime = (int) position * 5; // 5 minutes per token

        model.addAttribute("token", token);
        model.addAttribute("position", position + 1);
        model.addAttribute("estimatedTime", estimatedTime);

        return "token-status";
    }
}