package com.with.hyuil.dto.review;

import lombok.Data;

@Data
public class ReviewMainDto {
    private Long id;
    private int viewPage = 1;
    private int limit = 10;
    private int nowPage;
}
