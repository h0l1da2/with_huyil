package com.with.hyuil.controller.admin;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.TenPageHandler;
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
public class AdminPageController {

    private final BookService bookService;

    @GetMapping
    public String adminMain(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        return "management/index";
    }

    @GetMapping("/bookList")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookPageDto bookPageDto, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        List<AdminBookListDto> adminBookList = bookService.adminBookList(bookPageDto);
        TenPageHandler tenPageHandler = new TenPageHandler(adminBookList.get(0).getTotcnt(), bookPageDto.getNowPage());
        model.addAttribute(adminBookList);
        model.addAttribute("ph", tenPageHandler);
        return "book/adminBook";
    }

    @ResponseBody
    @PostMapping("/book/cancel")
    public String bookCancel(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody AdminBookListDto adminBookListDto, Model model) {
        return bookService.bookCancel(adminBookListDto.getId());
    }
}
