package com.with.hyuil.controller.login;

import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.FindIdDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FindInfoController {

    private final UsersService usersService;
    private final EmailService emailService;

    @GetMapping("/findPassword")
    public String findPwdForm(HttpServletRequest request, Model model) {
        refererSend(request, model);
        return "/info/passwordFindForm";
    }

    @ResponseBody
    @PostMapping("/findPassword")
    public String findPwd(@RequestBody EmailDto emailDto, HttpServletRequest request) {
        String referer = null;
        try {
            UsersVo user = usersService.loginForFind(emailDto.getUserId());
            if(!emailDto.getEmail().equals(user.getEmail())) {
                return "이메일이 다릅니다";
            }
            String randomPwd = UUID.randomUUID().toString().substring(0, 7);
            String newPassword = usersService.findPassword(new PasswordDto(
                    user.getUserId(), randomPwd, randomPwd));
            if (newPassword.equals("변경 오류")) {
                return "변경 오류";
            }
            emailService.passwordMailSend("WITH HYUIL 임시 비밀번호", newPassword, user.getEmail());
            referer = request.getHeader("referer");
            return referer.substring(21);
        } catch (NullPointerException e) {
            return "유저가 없습니다";
        }
    }

    @GetMapping("/findId")
    public String findId(HttpServletRequest request, Model model) {
        refererSend(request, model);
        return "/info/idFindForm";
    }

    @ResponseBody
    @PostMapping("/findId")
    public String findIdForm(@RequestBody FindIdDto findIdDto) {
        UsersVo user = usersService.findId(findIdDto);
        if (user == null) {
            return "유저 없음";
        }
        return emailService.idMailSend("WITH HYUIL 아이디", user.getUserId(), user.getEmail());
    }


    private void refererSend(HttpServletRequest request, Model model) {
        String referer = request.getHeader("referer");
        model.addAttribute("referer", referer);
    }
}
