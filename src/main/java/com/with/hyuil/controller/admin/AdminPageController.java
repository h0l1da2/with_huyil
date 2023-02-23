package com.with.hyuil.controller.admin;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.admin.AdminUserListDto;
import com.with.hyuil.dto.admin.TenPageHandler;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminPageController {

    private final BookService bookService;
    private final UsersService usersService;

    @GetMapping
    public String adminMain(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        return "management/index";
    }

    @GetMapping("/bookList")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute AdminPageDto adminPageDto, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        List<AdminBookListDto> adminBookList = bookService.adminBookList(adminPageDto);
        TenPageHandler tenPageHandler = new TenPageHandler(adminBookList.get(0).getTotcnt(), adminPageDto.getNowPage());
        model.addAttribute(adminBookList);
        model.addAttribute("ph", tenPageHandler);
        return "book/adminBook";
    }

    @ResponseBody
    @PostMapping("/book/cancel")
    public String bookCancel(@RequestBody AdminBookListDto adminBookListDto) {
        return bookService.bookCancel(adminBookListDto.getId());
    }

    @GetMapping("/hostList")
    public String hostList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute AdminPageDto adminPageDto, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        List<AdminUserListDto> adminHostList = usersService.adminHostList(adminPageDto);
        TenPageHandler tenPageHandler = new TenPageHandler(adminHostList.get(0).getTotcnt(), adminPageDto.getNowPage());
        model.addAttribute(adminHostList);
        model.addAttribute("ph", tenPageHandler);
        return "management/hostListForm";
    }
}
