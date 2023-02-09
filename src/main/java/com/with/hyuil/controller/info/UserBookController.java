package com.with.hyuil.controller.info;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Status;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/user/info")
public class UserBookController {

    private final BookService bookService;
    private final UsersService usersService;


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
            return "book/userBook";
        }
        return "book/userBook";
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
            return "book/userBookComplete";
        }
        return "book/userBookComplete";
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
            return "book/userBookCancel";
        }
        return "book/userBookCancel";
    }
    private static void getPage(BookSearchDto bookSearchDto, Model model, List<BookListDto> bookList) {
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(bookList.get(0).getTotcnt(), bookSearchDto.getNowPage());
        model.addAttribute("ph", globalPageHandler);
        model.addAttribute(bookList);
    }

    private List<BookListDto> getBookList(BookSearchDto bookSearchDto, UsersVo usersVo, Status complete) {
        bookSearchDto.setUserId(usersVo.getId());
        bookSearchDto.setStatus(complete);
        List<BookListDto> bookList = bookService.userBookList(bookSearchDto);
        return bookList;
    }

    private UsersVo findUser(String userDetails) {
        UsersVo usersVo = usersService.loginForFind(userDetails);
        return usersVo;
    }
}
