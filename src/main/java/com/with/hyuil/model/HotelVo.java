package com.with.hyuil.model;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class HotelVo {

    private Long id;
    private String name;
    private HotelInfoVo hotelInfoVo;
    private UsersVo usersVo;
    private ServiceVo serviceVo;
    private String address;
    private String zonecode;
    private String sigungu;
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
}
