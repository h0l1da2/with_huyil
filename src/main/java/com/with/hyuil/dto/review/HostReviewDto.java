package com.with.hyuil.dto.review;

import com.with.hyuil.model.enumaration.Type;
import lombok.Data;

@Data
public class HostReviewDto {

    private Long id;
    private Long hotelId;
    private Long reviewId;
    private Long replyId;
    private Long userLongId;
    private Long bookId;
    private String title;
    private String content;
    private Type userType;
}
