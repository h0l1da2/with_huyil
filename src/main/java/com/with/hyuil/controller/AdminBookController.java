package com.with.hyuil.controller;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.AdminPageHandler;
import com.with.hyuil.dto.admin.BookPageDto;
import com.with.hyuil.service.interfaces.BookService;
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
public class AdminBookController {

    private final BookService bookService;

    @GetMapping("/bookList")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookPageDto bookPageDto, Model model) {
//        model.addAttribute("userId", userDetails.getUsername());
        model.addAttribute("userId", "어드민");
        List<AdminBookListDto> adminBookList = bookService.adminBookList(bookPageDto);
        AdminPageHandler adminPageHandler = new AdminPageHandler(adminBookList.get(0).getTotcnt(), bookPageDto.getNowPage());
        model.addAttribute(adminBookList);
        model.addAttribute("ph", adminPageHandler);
        return "book/adminBook";
    }

    @ResponseBody
    @PostMapping("/book/cancel")
    public String bookCancel(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody AdminBookListDto adminBookListDto, Model model) {
        return bookService.bookCancel(adminBookListDto.getId());
    }
}
