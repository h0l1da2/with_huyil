package com.with.hyuil.controller.login;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.with.hyuil.dto.info.FindIdDto;
=======
import com.with.hyuil.config.jwt.JwtTokenProvider;
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
=======
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
=======
import com.with.hyuil.config.jwt.JwtTokenProvider;
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)
import com.with.hyuil.dto.users.UserCodeDto;
import com.with.hyuil.dto.users.UserIdDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.dto.users.UsersLoginDto;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.with.hyuil.model.RolesVo;
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
=======
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
=======
import com.with.hyuil.model.RolesVo;
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.context.annotation.PropertySource;
=======
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseCookie;
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
=======
import org.springframework.context.annotation.PropertySource;
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
=======
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseCookie;
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletResponse;
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class UsersJoinController {
    private final UsersService usersService;
    private final EmailService emailService;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)
    private final JwtTokenProvider jwtTokenProvider;
    private String jwtToken;

    @Value("${jwt.valid.time}")
    private Long validTime;
<<<<<<< HEAD
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
=======
    private final LoginServiceImpl loginService;
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
=======
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)

    @GetMapping("/join")
    public String joinUser() {
        return "user/joinForm";
    }

<<<<<<< HEAD
    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute UsersDto usersDto, HttpSession session) {
        String randomCode = emailService.codeMailSend("WITH HYUIL 가입 인증", usersDto.getEmail());
=======
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
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
        session.setAttribute("userDto", usersDto);
        session.setAttribute("randomCode", randomCode);
        return "user/joinEmailSend";
    }

<<<<<<< HEAD
    @ResponseBody
    @PostMapping("/join/telValid")
    public String emailValid(@RequestBody FindIdDto findIdDto, HttpSession session) {
        UsersVo user = usersService.findTel(findIdDto);
        if (user != null) {
            return "중복";
        }
        return "중복아님";
    }

=======
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public String loginUser(HttpServletRequest request) {

=======
    public String loginUser() {
>>>>>>> 9a6e574 (jwt 토큰 로컬스토리지 저장)
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersLoginDto usersLoginDto) {

        return "login";
    }

=======
    public String loginUser() {
=======
    public String loginUser(HttpServletRequest request, HttpServletResponse response) {
        loginService.haveRedirectURI(request, response);
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
        return "user/loginForm";
    }

>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
    private void sessionRemoveCodeAndDto(HttpSession session) {
        session.removeAttribute("randomCode");
        session.removeAttribute("userDto");
    }
}
