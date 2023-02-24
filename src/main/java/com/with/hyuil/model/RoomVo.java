package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomVo {

	private long id;
	private long hotelId;
	private String name;
	private String content;
	private int max;
	private String bed;
	private int normalPrice;
	private int holidayPrice;
	private long admincheckId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime removeDate;
}
