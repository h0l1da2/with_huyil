package com.with.hyuil.controller;

import com.with.hyuil.dto.users.AdminIdDto;
import com.with.hyuil.dto.users.AdminJoinDto;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminJoinController {

    private final UsersService usersService;

    @GetMapping
    public String adminLoginForm() {
        return "admin/adminLoginForm";
    }

    @GetMapping("/join")
    public String adminJoinForm() {
        return "admin/adminJoinForm";
    }

    @ResponseBody
    @PostMapping("/join/id")
    public String adminIdCheck(@RequestBody AdminIdDto adminIdDto) {
        return String.valueOf(
                usersService.adminIdCheck(adminIdDto.getAdminId()));
    }

    @PostMapping("/join")
    public String adminJoin(@ModelAttribute AdminJoinDto adminJoinDto) { //1111
        int result = usersService.saveAdmin(new AdminVo(adminJoinDto), adminJoinDto.getAdminPwd());
        if(result == 1) {
            return "redirect:/admins";
        }
        return "admin/adminJoinError";
    }
}
