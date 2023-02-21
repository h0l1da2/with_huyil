package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class StarDto {

    private Integer id;
    private Integer clean = 0;
    private Integer facilities = 0;
    private Integer condition = 0;
    private Integer organic = 0;
    private Integer totcnt = 0;
    private float reviewStars = 0f;

    public void calcForHotelList() {
        reviewStars = totcnt == 0 ? 0 : (clean+facilities+condition+organic)/totcnt/4;
    }
}
