package com.with.hyuil.dto.review;

import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.enumaration.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private Long hotelId;
    private Long bookId;
    private Long starId;
    private Long userLongId;
    private Long replyId;
    private String userId;
    private String title;
    private String content;
    private String userCreate;
    private Type userType;
    private Integer clean;
    private Integer facilities;
    private Integer condition;
    private Integer organic;

    public ReviewDto(ReviewVo reviewVo) {
        this.bookId = reviewVo.getBookId();
    }
}
