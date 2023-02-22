package com.with.hyuil.model;

import com.with.hyuil.dto.review.HostReviewDto;
import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.model.enumaration.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewVo {

    private Long id;
    private Long userId;
    private Long bookId;
    private String userCreate;
    private String content;
    private Long starId;
    private Long hotelId;
    private Type userType;
    private String title;
    private Long replyId;

    public ReviewVo(ReviewDto reviewDto) {
        this.userId = reviewDto.getUserLongId();
        this.bookId = reviewDto.getBookId();
        this.starId = reviewDto.getStarId();
        this.title = reviewDto.getTitle();
        this.content = reviewDto.getContent();
        this.userType = reviewDto.getUserType();
        this.hotelId = reviewDto.getHotelId();
    }
    public ReviewVo(HostReviewDto reviewDto) {
        this.userId = reviewDto.getUserLongId();
        this.bookId = reviewDto.getBookId();
        this.title = reviewDto.getTitle();
        this.content = reviewDto.getContent();
        this.userType = reviewDto.getUserType();
        this.hotelId = reviewDto.getHotelId();
        this.replyId = reviewDto.getReplyId();
    }


}
