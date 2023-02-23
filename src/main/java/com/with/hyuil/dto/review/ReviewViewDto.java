package com.with.hyuil.dto.review;

import com.with.hyuil.model.enumaration.Type;
import lombok.Data;

@Data
public class ReviewViewDto {

    private String title;
    private String content;
    private String userId;
    private Type type;
    private String userCreate;
    private Integer clean;
    private Integer facilities;
    private Integer condition;
    private Integer organic;
}
