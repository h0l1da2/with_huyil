package com.with.hyuil.controller;

import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final EmailService emailService;

    @GetMapping("/join")
    public String joinUser() {
        return "joinForm";
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, Model model) {
        String randomCode = emailService.joinMailSend(usersDto.getEmail());
        model.addAttribute("userDto", usersDto);
        model.addAttribute("randomCode", randomCode);
        return "joinEmailSend";
    }

    @ResponseBody
    @PostMapping("/join/id")
    public String joinUser(@RequestBody UserIdDto userIdDto) {
        return String.valueOf(usersService.idCheck(userIdDto));
    }

    @GetMapping("/login")
    public String loginUser() {
        return "loginForm";
    }
}
