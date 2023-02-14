package com.with.hyuil.controller;

import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/host")
public class HostJoinController {

    private final UsersService usersService;
    private final EmailService emailService;

    @GetMapping
    public String hostMain() {
        return "host/host";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "host/hostLoginForm";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "host/hostJoinForm";
    }

    @ResponseBody
    @PostMapping("/join/id")
    public String joinUser(@RequestBody UserIdDto userIdDto) {
        return String.valueOf(usersService.idCheck(userIdDto));
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, HttpSession session) {
        String randomCode = emailService.joinMailSend(usersDto.getEmail());
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
}
