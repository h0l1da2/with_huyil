package com.with.hyuil.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.with.hyuil.config.auth.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;

import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.BusinessVo;


import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


<<<<<<< HEAD
=======
=======
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;

import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.BusinessVo;


import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/host")
public class HostJoinController {

    private final UsersService usersService;
    private final EmailService emailService;

    @GetMapping
    public String hostMain(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        try {
            model.addAttribute("userId", userDetails.getUsername());
            model.addAttribute("role", userDetails.getAuthorities().toString());
        } catch (NullPointerException e) {
            return "host/host";
        }
        return "host/host";
    }

    @GetMapping("/loginForm")
    public String loginHost(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer requestURL = request.getRequestURL();
        request.setAttribute("requestURL", requestURL);
        return "host/hostLoginForm";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "host/hostJoinForm";
    }

    @ResponseBody
    @PostMapping("/join/id")
    public String joinUser(@RequestBody UserIdDto userIdDto) {
        log.info("유저아이디? = {}", userIdDto.getUserId());
        return String.valueOf(usersService.idCheck(userIdDto));
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, HttpSession session) {
        String randomCode = emailService.codeMailSend("WITH HYUIL 가입 인증", usersDto.getEmail());
        session.setAttribute("usersDto", usersDto);
        session.setAttribute("randomCode", randomCode);
        return "host/hostJoinEmailSend";
    }

    @PostMapping("/join/emailCode")
    public String joinEmail(@ModelAttribute UserCodeDto userCodeDto, HttpSession session) {
        String randomCode = session.getAttribute("randomCode").toString();
        if(randomCode.equals(userCodeDto.getRandomCode())) {
            UsersDto usersDto = (UsersDto) session.getAttribute("usersDto");
            UsersVo usersVo = new UsersVo(usersDto);
            usersVo.hostUser(usersDto);
            usersService.saveHost(usersVo);
            sessionRemoveCodeAndDto(session);

            log.info("호스트 회원 가입 = {}", usersDto.getUserId());
            return "host/hostJoinComplete";
        }
        sessionRemoveCodeAndDto(session);
        return "host/hostJoinError";
    }

    private void sessionRemoveCodeAndDto(HttpSession session) {
        session.removeAttribute("randomCode");
        session.removeAttribute("userDto");
    }

    @GetMapping("/hostForm")
    public String balondor(Model model) {
        String id = "messi";
        UsersVo usersvo = usersService.loginForFind(id);
        System.out.println(usersvo.getBusinessVo());
        model.addAttribute("users", usersvo);
        return "/hotel/hostForm";
    }

    @PostMapping("/hostForm")
    public String benzema(BusinessVo businessvo) {
        String id = "messi";
        UsersVo usersvo = usersService.loginForFind(id);
        return "redirect:/host/hotelForm";
    }

}