package com.with.hyuil.controller.info;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.info.DeleteDto;
import com.with.hyuil.dto.info.EmailDto;
import com.with.hyuil.dto.info.PasswordDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/user/info")
public class UserInfoController {

    private final UsersService usersService;
    private final EmailService emailService;
    private String code;

    //테스트용
//    @GetMapping
//    public String userInfo(Model model) {
//        model.addAttribute("userId", "user");
//        model.addAttribute("username", "휴일");
//        return "user/userInfo";
//    }
    @GetMapping
    public String userInfo(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        model.addAttribute("userId", username);
        UsersVo usersVo = findUser(username);
        if (usersVo == null) {
            return "user/loginForm";
        }
        model.addAttribute("username", usersVo.getName());
        return "user/userInfo";
    }

    @ResponseBody
    @PostMapping("/modify/emailValid")
    public String emailValid(@RequestBody EmailDto emailDto, Model model) {
        UsersVo user = usersService.emailValid(emailDto);
        if (user == null) {
            log.info("유저없덩");
            return "false";
        }
        log.info("유저있당!");
        code = emailService.codeMailSend("WITH HYUIL 이메일 변경", emailDto.getNewEmail());
        model.addAttribute("code", code);
        return "true";
    }

    @ResponseBody
    @PostMapping("/modify/email")
    public String emailModify(@RequestBody EmailDto emailDto) {
        if (code.equals(emailDto.getCode())) {
            int i = usersService.modifyEmail(emailDto);
            if (i == 1) {
                log.info("수정 완료");
                return "true";
            }
        }
        return "false";
    }

    @ResponseBody
    @PostMapping("/modify/password")
    public String passwordModify(@RequestBody PasswordDto passwordDto) {
        return usersService.modifyPassword(passwordDto);
    }

    @GetMapping("/delete")
    public String deletePage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        model.addAttribute("userId", username);
        return "user/userDelete";
    }

    @ResponseBody
    @PostMapping("/delete")
    public String deletePage(@RequestBody DeleteDto deleteDto) {
        return usersService.deleteUser(deleteDto);
    }

    private UsersVo findUser(String userDetails) {
        UsersVo usersVo = usersService.loginForFind(userDetails);
        return usersVo;
    }

}
