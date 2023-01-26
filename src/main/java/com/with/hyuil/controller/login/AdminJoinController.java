package com.with.hyuil.controller.login;

import com.with.hyuil.dto.users.AdminJoinDto;
import com.with.hyuil.dto.users.UserIdDto;
<<<<<<< HEAD
=======
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.dto.users.UsersLoginDto;
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

=======
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminJoinController {
//서비스에서 생긴 예외 컨트롤러에서 예외 처리?
    private final UsersService usersService;

    @GetMapping
<<<<<<< HEAD
    public String adminLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer requestURL = request.getRequestURL();
        request.setAttribute("requestURL", requestURL);
=======
    public String adminLoginForm() {
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
        return "admin/adminLoginForm";
    }

    @GetMapping("/join")
    public String adminJoinForm() {
        return "admin/adminJoinForm";
    }

    @ResponseBody
    @PostMapping("/join/id")
    public String adminIdCheck(@RequestBody UserIdDto userIdDto) {
        return String.valueOf(
                usersService.idCheck(userIdDto));
    }

    @PostMapping("/join")
    public String adminJoin(@ModelAttribute AdminJoinDto adminJoinDto) { //1111
        log.info("어드민코드 = {}", adminJoinDto.getAdminCode());
        log.info("어드민id = {}", adminJoinDto.getUserId());
        log.info("어드민이름 = {}", adminJoinDto.getName());
        int result = usersService.saveAdmin(new UsersVo(adminJoinDto), adminJoinDto.getAdminCode());
        if(result == 1) {
            return "redirect:/admins";
        }
        return "admin/adminJoinError";
    }
<<<<<<< HEAD

    @GetMapping("/loginForm")
    public String loginHost(HttpServletRequest request, HttpServletResponse response) {
        return "host/hostLoginForm";
    }

=======
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
}
