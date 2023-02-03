package com.with.hyuil.controller;

<<<<<<< HEAD
import com.with.hyuil.config.auth.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
=======
import lombok.extern.slf4j.Slf4j;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
<<<<<<< HEAD
    public String main(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        try {
            model.addAttribute("userId", userDetails.getUsername());
            model.addAttribute("role", userDetails.getAuthorities().toString());
=======
    public String main(HttpServletRequest request, Model model) {
        try {
            HttpSession session = request.getSession();
            String userId = session.getAttribute("userId").toString();
            model.addAttribute("userId", userId);
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        } catch (NullPointerException e) {
            return "index";
        }
        return "index";
    }

}
