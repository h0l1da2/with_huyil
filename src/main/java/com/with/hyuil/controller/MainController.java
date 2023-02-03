package com.with.hyuil.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) {
        try {
            HttpSession session = request.getSession();
            String userId = session.getAttribute("userId").toString();
            model.addAttribute("userId", userId);
        } catch (NullPointerException e) {
            return "index";
        }
        return "index";
    }

}
