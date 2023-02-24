package com.with.hyuil.controller.admin;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.admin.*;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.OrderService;
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
    private final OrderService orderService;

    @GetMapping
    public String adminMain(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        // 총 회원
        Integer allUsers = usersService.allCntForAdmin();
        // 일반 유저 수
        Integer users = usersService.userCntForAdmin();
        // 호스트 유저 수
        Integer hosts = usersService.hostCntForAdmin();

        Integer totalPrice = orderService.sumTotalPrice();

        //list 사이즈만큼 돌려서 모델 집어넣기
        model.addAttribute("userId", userDetails.getUsername());
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("users", users);
        model.addAttribute("hosts", hosts);
        model.addAttribute("totalPrice", totalPrice);
        return "management/index";
    }

    @GetMapping("/bookList")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute AdminPageDto adminPageDto, Model model) {
        List<AdminBookListDto> adminBookList = bookService.adminBookList(adminPageDto);
        TenPageHandler tenPageHandler = getTenPageHandler(adminBookList.get(0).getTotcnt(), adminPageDto);
        modelAddList(model, adminBookList, tenPageHandler, userDetails);
        return "book/adminBook";
    }

    @ResponseBody
    @PostMapping("/book/cancel")
    public String bookCancel(@RequestBody AdminBookListDto adminBookListDto) {
        return bookService.bookCancel(adminBookListDto.getId());
    }

    @GetMapping("/hostList")
    public String hostList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute AdminPageDto adminPageDto, Model model) {
        List<AdminUserListDto> adminHostList = usersService.adminHostList(adminPageDto);
        TenPageHandler tenPageHandler = getTenPageHandler(adminHostList.get(0).getTotcnt(), adminPageDto);
        modelAddList(model, adminHostList, tenPageHandler, userDetails);
        return "management/hostListForm";
    }

    @GetMapping("/userList")
    public String userList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute AdminPageDto adminPageDto, Model model) {
        List<AdminUserListDto> adminUserList = usersService.adminUserList(adminPageDto);
        TenPageHandler tenPageHandler = getTenPageHandler(adminUserList.get(0).getTotcnt(), adminPageDto);
        modelAddList(model, adminUserList, tenPageHandler, userDetails);
        return "management/userListForm";
    }

    @ResponseBody
    @PostMapping("/stopUsers")
    public String stopUser(@RequestBody StopDto stopDto) {
        return usersService.stopUser(stopDto);
    }

    private TenPageHandler getTenPageHandler(Integer adminUserList, AdminPageDto adminPageDto) {
        TenPageHandler tenPageHandler = new TenPageHandler(adminUserList, adminPageDto.getNowPage());
        return tenPageHandler;
    }

    private void modelAddList(
            Model model, List<? extends Object> adminHostList, TenPageHandler tenPageHandler, CustomUserDetails userDetails) {
        model.addAttribute("userId", userDetails.getUsername());
        model.addAttribute(adminHostList);
        model.addAttribute("ph", tenPageHandler);
    }
}
