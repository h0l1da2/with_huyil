package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class HotelSearchDto {

    private String sido;
    private Integer max;
    private String checkIn;
    private String checkOut;
    private int offset = 0;
    private final int limit = 6;

}
