package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class HotelListDto {

    private Long id;
    private String name;
    private Integer star;
    private Integer price;
    private String sigungu;
    private String path;
    private Integer totcnt;

}
