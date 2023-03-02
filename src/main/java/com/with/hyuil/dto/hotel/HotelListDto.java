package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class HotelListDto {

    private Long id;
    private String name;
    private Float star = 0f;
    private Integer price;
    private String sigungu;
    private Integer clean;
    private Integer facilities;
    private Integer condition;
    private Integer organic;
    private String uuid;
    private String imgSrc = "/img?filename=";
    private int totcnt;
    private int totalStar;

    public void calcForHotelList() {
        star = totalStar == 0 ? 0 : (clean+facilities+condition+organic)/totalStar/4f;
    }


}
