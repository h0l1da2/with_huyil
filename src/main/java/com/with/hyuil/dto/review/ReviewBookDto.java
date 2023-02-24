package com.with.hyuil.dto.review;

import lombok.Data;

@Data
public class ReviewBookDto {

    private Long userId;
    private Long hotelId;
    private Long bookId;

    public ReviewBookDto(Long hotelId, Long userId) {
        this.hotelId = hotelId;
        this.userId = userId;
    }
}
