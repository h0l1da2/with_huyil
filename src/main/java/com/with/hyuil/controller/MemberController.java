package com.with.hyuil.controller;

import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("member/list.do")
    public String memberList(Model model){
        //controller -> service -> dao요청
        List<UsersVo> list= memberService.memberList();
        model.addAttribute("list", list);

        return "management/tables";
    }


}
