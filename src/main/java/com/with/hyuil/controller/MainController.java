package com.with.hyuil.controller;

import com.with.hyuil.config.auth.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String main(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        try {
            model.addAttribute("userId", userDetails.getUsername());
            model.addAttribute("role", userDetails.getAuthorities().toString());
            log.info("role = {}", userDetails.getAuthorities().toString());
        } catch (NullPointerException e) {
            return "index";
        }
        return "index";
    }

}
