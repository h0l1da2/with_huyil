package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HotelInfoVo {

    private long id;
    private String traffic;
    private String intro;
    private String spot;
    private String policy;
    private String checkIn;
    private String checkOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime removeDate;
}