package com.with.hyuil.controller.admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminMemberController {

    private MemberService memberService;
    private Rq rq;

    @Autowired
    public AdminMemberController(MemberService memberService, Rq rq) {
        this.memberService = memberService;
        this.rq = rq;
    }

    @RequestMapping("/adm/member/list")
    public String showList(Model model, @RequestParam(defaultValue = "0") String authLevel,
                           @RequestParam(defaultValue = "loginId,name,nickname") String searchKeywordTypeCode,
                           @RequestParam(defaultValue = "") String searchKeyword, @RequestParam(defaultValue = "1") int page) {

        int membersCount = memberService.getMembersCount(authLevel, searchKeywordTypeCode, searchKeyword);

        if (page <= 0) {
            return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
        }

        int itemsInAPage = 10;
        int pagesCount = (int) Math.ceil((double) membersCount / itemsInAPage);

        List<Member> members = memberService.getMembers(authLevel, searchKeywordTypeCode, searchKeyword, itemsInAPage,
                page);

        model.addAttribute("authLevel", authLevel);
        model.addAttribute("searchKeywordTypeCode", searchKeywordTypeCode);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("page", page);
        model.addAttribute("members", members);
        model.addAttribute("membersCount", membersCount);
        model.addAttribute("pagesCount", pagesCount);

        return "adm/member/list";
    }
}