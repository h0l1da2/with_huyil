package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class HotelListDto {

    private Long id;
    private String name;
    private Float star = 0f;
    private Integer price;
    private String sigungu;
    private String uuid;
    private String imgSrc = "/img?filename=";
    private int totcnt;
}
