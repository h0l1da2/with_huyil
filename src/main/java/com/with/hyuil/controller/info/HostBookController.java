package com.with.hyuil.controller.info;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Status;
import com.with.hyuil.service.interfaces.BookService;
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
@RequestMapping("/hosts/info")
public class HostBookController {

    private final BookService bookService;
    private final UsersService usersService;


    @GetMapping("/book")
    public String bookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        UsersVo usersVo = getUsersVo(userDetails.getUsername());
        List<HostBookListDto> bookList = getBookList(bookSearchDto, Status.READY, usersVo);

        try {
            getPage(bookSearchDto, model, bookList);
            sendIdRole(userDetails, model);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과 없음");
            return "book/hostBook";
        }
        return "book/hostBook";
    }

    @ResponseBody
    @PostMapping("/book/cancel")
    public String cancelBook(@RequestBody HostBookListDto hostBookListDto) {
        return bookService.bookCancel(hostBookListDto.getId());
    }

    @GetMapping("/book/complete")
    public String completeBookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        UsersVo usersVo = getUsersVo(userDetails.getUsername());
        List<HostBookListDto> bookList = getBookList(bookSearchDto, Status.COMPLETE, usersVo);
        try {
            getPage(bookSearchDto, model, bookList);
            sendIdRole(userDetails, model);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과 없음");
            return "book/hostBookComplete";
        }
        return "book/hostBookComplete";
    }

<<<<<<< HEAD
    @GetMapping("/book/cancel")
    public String cancelBookList(@AuthenticationPrincipal CustomUserDetails userDetails, @ModelAttribute BookSearchDto bookSearchDto, Model model) {
        UsersVo usersVo = getUsersVo(userDetails.getUsername());
        List<HostBookListDto> bookList = getBookList(bookSearchDto, Status.CANCEL, usersVo);
        try {
            getPage(bookSearchDto, model, bookList);
            sendIdRole(userDetails, model);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과 없음");
            return "book/hostBookComplete";
        }
        return "book/hostBookComplete";
    }

=======
>>>>>>> c3c0dad9ef57c4812c6913cc3f18fef57ba4d00e
    private List<HostBookListDto> getBookList(BookSearchDto bookSearchDto, Status complete, UsersVo usersVo) {
        bookSearchDto.setStatus(complete);
        bookSearchDto.setUserId(usersVo.getId());
        List<HostBookListDto> bookList = bookService.hostBookList(bookSearchDto);
        return bookList;
    }
    private static void getPage(BookSearchDto bookSearchDto, Model model, List<HostBookListDto> bookList) {
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(bookList.get(0).getTotcnt(), bookSearchDto.getNowPage());
        log.info("phHandler = {}", globalPageHandler);
        model.addAttribute(bookList);
        model.addAttribute("ph", globalPageHandler);
    }

    private UsersVo getUsersVo(String userDetails) {
        return usersService.loginForFind(userDetails);
    }

    private void sendIdRole(CustomUserDetails userDetails, Model model) {
        model.addAttribute("userId", userDetails.getUsername());
        model.addAttribute("role", userDetails.getAuthorities().toString());
    }
}