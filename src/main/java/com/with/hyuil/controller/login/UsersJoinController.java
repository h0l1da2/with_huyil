package com.with.hyuil.controller.login;

import com.with.hyuil.config.jwt.JwtTokenProvider;
import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.dto.users.UsersLoginDto;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class UsersJoinController {
    private final UsersService usersService;
    private final EmailService emailService;
    private final JwtTokenProvider jwtTokenProvider;
    private String jwtToken;

    @Value("${jwt.valid.time}")
    private Long validTime;

    @GetMapping("/join")
    public String joinUser() {
        return "user/joinForm";
    }

    @ResponseBody
    @PostMapping("/login")
    public String loginUsers(@RequestBody UsersLoginDto loginDto, HttpServletResponse response, HttpServletRequest request) {
        log.info("id = {}", loginDto.getUserId());
        log.info("password = {}", loginDto.getPassword());
        UsersVo user = usersService.login(new UsersVo(loginDto));
        String userId = user.getUserId();
        RolesVo rolesVo = usersService.roleForLogin(user.getId());
        jwtToken = jwtTokenProvider.createJwtToken(userId, rolesVo.getRoleName().toString());
        String refreshToken = jwtTokenProvider.createRefreshToken();
        response.setHeader("Authorization", "Bearer "+jwtToken);

        ResponseCookie cookie = ResponseCookie.from("refresh_token", refreshToken)
                .maxAge(60 * 60 * 3 * 1)
                .httpOnly(true)
                .build();

        response.setHeader("Cookie", refreshToken);
        return jwtToken;
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, HttpSession session) {
        String randomCode = emailService.joinMailSend(usersDto.getEmail());
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
    public String loginUser() {
        return "user/loginForm";
    }

    private void sessionRemoveCodeAndDto(HttpSession session) {
        session.removeAttribute("randomCode");
        session.removeAttribute("userDto");
    }
}
