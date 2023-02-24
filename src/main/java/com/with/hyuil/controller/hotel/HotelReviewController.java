package com.with.hyuil.controller.hotel;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.review.HostReviewDto;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.dto.review.ReviewMainDto;
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

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/hotel/review")
@RequiredArgsConstructor
public class HotelReviewController {

    private final ReviewService reviewService;
    private final UsersService usersService;
    private final BookService bookService;
    private final HotelService hotelService;

    @GetMapping
    public String reviewPage(@ModelAttribute ReviewMainDto reviewMainDto, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        if(userDetails != null) {
            UsersVo usersVo = usersService.loginForFind(userDetails.getUsername());
            BookVo bookVo = bookService.notReviewFind(new ReviewBookDto(reviewMainDto.getId(), usersVo.getId()));
            model.addAttribute("userLongId", usersVo.getId());
            if (bookVo != null) {
                model.addAttribute("bookId", bookVo.getId());
            }
        }
        HotelVo hotelVo = hotelService.findByHotelId(reviewMainDto.getId());
        model.addAttribute("hotelVo", hotelVo);
        List<ReviewDto> reviewDto = reviewService.findHotelReviews(hotelVo.getId());
        model.addAttribute(reviewDto);
        /**
         * 1.Reply_id 가 null 인 해당 hotel_id 를 가진 ReviewDto 받아옴
         * 2.Reply_id 가 null 이 아닌 것들 중에서 WHERE ID IN (?,?, ...) 를 가져옴
         * 3.둘 다 데려와서 페이징
         */
        return "hotel/hotelReview";
    }



    @ResponseBody
    @PostMapping("/write")
    public String userReview(@RequestBody ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails userDetails) {
        log.info("리뷰디티오들어옴 = {}", reviewDto);
        // 어썬티케이션 자르기
        reviewDto.setUserType(
                userDetails.getAuthorities().toString().contains(Type.USER.toString()) ? Type.USER : Type.HOST
        );
        log.info("리뷰디티오? = {}", reviewDto);
        StarVo starVo = reviewService.saveStar(new StarVo(reviewDto));
        reviewDto.setStarId(starVo.getId());
        ReviewVo reviewVo = reviewService.writeReview(new ReviewVo(reviewDto));

        // book 에 해당 review Id 가져와서 넣기
        int result = bookService.writeBookReview(reviewVo);
        if (result == 0) {
            log.info("리뷰 안써짐");
            return "리뷰 실패";
        }
        return "리뷰 성공";
    }

    @PostMapping("/write/host")
    public String hostReview(@ModelAttribute HostReviewDto hostReviewDto, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        log.info("리뷰디티오들어옴 = {}", hostReviewDto);
        // 어썬티케이션 자르기
        hostReviewDto.setUserType(
                userDetails.getAuthorities().toString().contains(Type.USER.toString()) ? Type.USER : Type.HOST
        );
        hostReviewDto.setUserLongId(hostReviewDto.getUserLongId());
        ReviewDto reviewBook = reviewService.findReviewBook(hostReviewDto.getReplyId());
        hostReviewDto.setBookId(reviewBook.getBookId());
        reviewService.writeHostReview(new ReviewVo(hostReviewDto));
        return "redirect:/hotel/review?id="+hostReviewDto.getHotelId();
    }
}
