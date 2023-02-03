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

<<<<<<< HEAD
    public HotelSearchDto(String sido, Integer max, String checkIn, String checkOut) {
        this.sido = sido;
        this.max = max;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public HotelSearchDto() {
    }
=======
>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d
}
