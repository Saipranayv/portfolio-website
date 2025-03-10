package com.saipranay.portfolio.service;

import com.saipranay.portfolio.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@yourportfolio.com");
        message.setTo("vuchidisai@gmail.com"); // Replace with your actual email
        message.setSubject("Portfolio Contact: " + contactForm.getSubject());
        
        String emailContent = "Name: " + contactForm.getName() + "\n"
                + "Email: " + contactForm.getEmail() + "\n\n"
                + "Message:\n" + contactForm.getMessage();
        
        message.setText(emailContent);
        mailSender.send(message);
    }
}
