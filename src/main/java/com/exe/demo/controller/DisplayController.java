package com.exe.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.exe.demo.model.Token;
import com.exe.demo.repository.TokenRepository;

@Controller
public class DisplayController {

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/display")
    public String displayScreen(Model model) {

        // Latest called token
        Token currentToken = tokenRepository
                .findTopByStatusOrderByIdDesc("CALLED");

        // Next 3 waiting tokens
        List<Token> nextTokens = tokenRepository
                .findTop3ByStatusOrderByIdAsc("WAITING");

        model.addAttribute("currentToken", currentToken);
        model.addAttribute("nextTokens", nextTokens);

        return "display";
    }
}
