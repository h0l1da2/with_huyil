package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HotelVo {


	private long id;
	private String name;
	private long hotelInfoId;
	private long userId;
	private String service;
	private String zonecode;
	private String sido;
	private String sigungu;
	private String address;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime removeDate;
}