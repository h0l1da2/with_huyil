package com.with.hyuil.controller.login;

import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class UsersJoinController {
    private final UsersService usersService;
    private final EmailService emailService;

    @GetMapping("/join")
    public String joinUser() {
        return "user/joinForm";
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, HttpSession session) {
        String randomCode = emailService.codeMailSend("WITH HYUIL 가입 인증", usersDto.getEmail());
        session.setAttribute("userDto", usersDto);
        session.setAttribute("randomCode", randomCode);
        return "user/joinEmailSend";
    }

    @PostMapping("/join/emailCode")
    public String checkEmail(@ModelAttribute UserCodeDto userCodeDto, HttpSession session) {
        String randomCode = (String) session.getAttribute("randomCode");
        if(randomCode.equals(userCodeDto.getRandomCode())) {
            UsersVo usersVo =
                    new UsersVo(
                            (UsersDto) session.getAttribute("userDto"));
            usersVo.userRoleWheres();
            usersService.saveUser(usersVo);
            sessionRemoveCodeAndDto(session);
            log.info("유저 회원 가입 = {}", usersVo.getUserId());
            return "user/joinComplete";
        }
        sessionRemoveCodeAndDto(session);
        return "user/joinError";
    }


    @ResponseBody
    @PostMapping("/join/id")
    public String joinUser(@RequestBody UserIdDto userIdDto) {
        return String.valueOf(usersService.idCheck(userIdDto));
    }

    @GetMapping("/loginForm")
    public String loginUser(HttpServletRequest request) {

        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersLoginDto usersLoginDto) {

        return "login";
    }

    private void sessionRemoveCodeAndDto(HttpSession session) {
        session.removeAttribute("randomCode");
        session.removeAttribute("userDto");
    }
}
