package com.with.hyuil.controller.info;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.*;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Status;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.EmailService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/hosts/info")
@RequiredArgsConstructor
public class HostInfoController {

    private final UsersService usersService;
    private final EmailService emailService;
    private String code;

    @GetMapping
    public String hostInfo(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        model.addAttribute("userId", username);
        UsersVo usersVo = getUsersVo(username);
        if (usersVo == null) {
            return "host/hostLoginForm";
        }
        BusinessDto businessDto = usersService.findBusinessDto(usersVo.getBusinessId());
        model.addAttribute("username", usersVo.getName());
        model.addAttribute("business", businessDto);
        return "host/hostInfo";
    }

    @ResponseBody
    @PostMapping("/modify/emailValid")
    public String emailValid(@RequestBody EmailDto emailDto, Model model) {
        log.info("emailDto = {}", emailDto);
        UsersVo usersVo = usersService.emailValid(emailDto);
        if (usersVo == null) {
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
        log.info("emailDto = {}", emailDto);
        if (code.equals(emailDto.getCode())) {
            log.info("코드가 같다!");
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


    private UsersVo getUsersVo(String userDetails) {
        return usersService.loginForFind(userDetails);
    }
}
