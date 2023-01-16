package com.with.hyuil.model;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class HotelInfoVo {

    private Long id;
    private String traffic;
    private String intro;
    private String spot;
    private String polish;
    private Date checkIn;
    private Date checkOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime close;
    private File file;
}
