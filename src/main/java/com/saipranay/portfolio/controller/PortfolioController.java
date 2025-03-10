package com.saipranay.portfolio.controller;

import com.saipranay.portfolio.model.ContactForm;
import com.saipranay.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortfolioController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/api/contact")
    @ResponseBody
    public ResponseEntity<String> processContactForm(@RequestBody ContactForm contactForm) {
        try {
            // Send email with form details
            emailService.sendContactEmail(contactForm);
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to send message: " + e.getMessage());
        }
    }
}
