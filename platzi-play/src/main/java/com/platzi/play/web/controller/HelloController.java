package com.platzi.play.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.play.domain.service.PlayAiService;

@RestController
public class HelloController {
    private final PlayAiService aiService;
    private final String platform;

    public HelloController(
    @Value("${spring.application.name}")String platform,
    
    PlayAiService aiService) {
        this.aiService = aiService;
        this.platform = platform;
    }

    @GetMapping("/")
    public String hello() {
        return aiService.generatedGreeting(platform);
    }
}
