package com.with.hyuil.model;

import com.with.hyuil.dto.review.ReviewDto;
import lombok.Getter;

@Getter
public class StarVo {

    private Long id;
    private Integer clean;
    private Integer facilities;
    private Integer condition;
    private Integer organic;
    private Long userId;
    private Long hotelId;

    public StarVo(ReviewDto reviewDto) {
        this.clean = reviewDto.getClean();
        this.facilities = reviewDto.getFacilities();
        this.condition = reviewDto.getCondition();
        this.organic = reviewDto.getOrganic();
        this.hotelId = reviewDto.getHotelId();
        this.userId = reviewDto.getUserId();
    }

    public void myUserId(Long userId) {
        this.userId = userId;
    }
}
