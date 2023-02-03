package com.with.hyuil.config;

import com.with.hyuil.service.EmailServiceImpl;
import com.with.hyuil.service.interfaces.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@RequiredArgsConstructor
public class EmailConfig {

    private final JavaMailSender javaMailSender;

    @Bean
    public EmailService emailService() {
        return new EmailServiceImpl(javaMailSender);
    }
}
