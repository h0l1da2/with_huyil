package com.with.hyuil.controller.user;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.info.*;
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

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/user/info")
public class UserInfoController {

    private final UsersService usersService;
    private final EmailService emailService;
    private final BookService bookService;
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

//    @GetMapping("/book")
//    public String bookList(@ModelAttribute BookSearchDto bookSearchDto, Model model) {
//        // 유저아이디로 해당 유저 예약 목록 가져옴
//        UsersVo usersVo = usersService.loginForFind("KAKAO_2616028737");
//        bookSearchDto.setUserId(usersVo.getId());
//        List<BookListDto> bookList = bookService.bookList(bookSearchDto);
//        model.addAttribute("bookList", bookList);
//        return "user/userBook";
//    }
    @GetMapping("/book")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        // 유저아이디로 해당 유저 예약 목록 가져옴
        log.info("bookSearchDto = {}", bookSearchDto);
        UsersVo usersVo = findUser(userDetails.getUsername());
        List<BookListDto> bookList = getBookList(bookSearchDto, usersVo, Status.READY);
        log.info("bookList = {}", bookList);
        // 토탈카운트 먹어야됨 먼저
        try {
            getPage(bookSearchDto, model, bookList);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            return "user/userBook";
        }
        return "user/userBook";
    }

    @GetMapping("/book/complete")
    public String endBookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        // 유저아이디로 해당 유저 예약 목록 가져옴
        log.info("bookSearchDto = {}", bookSearchDto);
        UsersVo usersVo = findUser(userDetails.getUsername());
        List<BookListDto> bookList = getBookList(bookSearchDto, usersVo, Status.COMPLETE);
        log.info("bookList = {}", bookList);
        // 토탈카운트 먹어야됨 먼저
        try {
            getPage(bookSearchDto, model, bookList);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            return "user/userBookComplete";
        }
        return "user/userBookComplete";
    }

    @GetMapping("/book/cancel")
    public String cancelBookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        // 유저아이디로 해당 유저 예약 목록 가져옴
        log.info("bookSearchDto = {}", bookSearchDto);
        UsersVo usersVo = findUser(userDetails.getUsername());
        List<BookListDto> bookList = getBookList(bookSearchDto, usersVo, Status.CANCEL);
        log.info("bookList = {}", bookList);
        // 토탈카운트 먹어야됨 먼저
        try {
            getPage(bookSearchDto, model, bookList);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            return "user/userBookCancel";
        }
        return "user/userBookCancel";
    }

    private static void getPage(BookSearchDto bookSearchDto, Model model, List<BookListDto> bookList) {
        log.info("ㅌ토탈카운트 = {}", bookList.get(0).getTotcnt());
        log.info("뷰페이지 = {}", bookSearchDto.getViewPage());
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(bookList.get(0).getTotcnt(), bookSearchDto.getNowPage());
        log.info("핸들러 = {}", globalPageHandler);
        model.addAttribute("ph", globalPageHandler);
        model.addAttribute(bookList);
    }

    private List<BookListDto> getBookList(BookSearchDto bookSearchDto, UsersVo usersVo, Status complete) {
        bookSearchDto.setUserId(usersVo.getId());
        bookSearchDto.setStatus(complete);
        List<BookListDto> bookList = bookService.bookList(bookSearchDto);
        return bookList;
    }

    private UsersVo findUser(String userDetails) {
        UsersVo usersVo = usersService.loginForFind(userDetails);
        return usersVo;
    }

}
