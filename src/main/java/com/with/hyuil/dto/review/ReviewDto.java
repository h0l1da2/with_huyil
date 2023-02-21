package com.with.hyuil.dto.review;

import com.with.hyuil.model.enumaration.Type;
import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private Long hotelId;
    private Long bookId;
    private Long starId;
    private Long userId;
    private String title;
    private String content;
    private Type userType;
    private Integer clean;
    private Integer facilities;
    private Integer condition;
    private Integer organic;

}
