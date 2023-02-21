package com.with.hyuil.controller.hotel;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.model.*;
import com.with.hyuil.model.enumaration.Type;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.HotelService;
import com.with.hyuil.service.interfaces.ReviewService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/hotel/review")
@RequiredArgsConstructor
public class HotelReviewController {

    private final ReviewService reviewService;
    private final UsersService usersService;
    private final BookService bookService;
    private final HotelService hotelService;

//    @GetMapping
//    public String reviewPage(@RequestParam Long id, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
//        if(userDetails != null) {
//            UsersVo usersVo = usersService.loginForFind(userDetails.getUsername());
//            BookVo bookVo = bookService.notReviewFind(new ReviewBookDto(id, usersVo.getId()));
//            model.addAttribute("userLongId", usersVo.getId());
//            if (bookVo != null) {
//                model.addAttribute("bookId", bookVo.getId());
//            }
//        }
//        HotelVo hotelVo = hotelService.findByHotelId(id);
//        model.addAttribute("hotelVo", hotelVo);
//        return "hotel/hotelReview";
//    }

    @GetMapping
    public String reviewPage(@RequestParam Long id, Model model) {
        UsersVo usersVo = usersService.loginForFind("KAKAO_2616028737");
        BookVo bookVo = bookService.notReviewFind(new ReviewBookDto(id, usersVo.getId()));
        HotelVo hotelVo = hotelService.findByHotelId(id);
        model.addAttribute(hotelVo);
        model.addAttribute("userLongId", usersVo.getId());
        if (bookVo != null) {
            model.addAttribute("bookId", bookVo.getId());
        }
        return "hotel/hotelReview";
    }

//    @PostMapping("/write")
//    public String userReview(@ModelAttribute ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails userDetails) {
//        log.info("리뷰디티오들어옴 = {}", reviewDto);
//        reviewDto.setUserType(
//                userDetails.getAuthorities().contains(Type.USER) ? Type.USER : Type.HOST
//        );
//        StarVo starVo = reviewService.saveStar(new StarVo(reviewDto));
//        reviewDto.setStarId(starVo.getId());
//        ReviewVo reviewVo = reviewService.writeReview(new ReviewVo(reviewDto));
//        return null;
//    }

    @PostMapping("/write")
    public String userReview(@ModelAttribute ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails userDetails) {
        log.info("리뷰디티오들어옴 = {}", reviewDto);
        // 어썬티케이션 자르기
        reviewDto.setUserType(
                userDetails.getAuthorities().toString().contains(Type.USER.toString()) ? Type.USER : Type.HOST
        );
        log.info("리뷰디티오? = {}", reviewDto);
        StarVo starVo = reviewService.saveStar(new StarVo(reviewDto));
        reviewDto.setStarId(starVo.getId());
        reviewService.writeReview(new ReviewVo(reviewDto));
        // book 에 해당 review Id ㄱㅏ져와서 넣기ㅎㅎ
        return "hotel/hotelReview";
    }
}
