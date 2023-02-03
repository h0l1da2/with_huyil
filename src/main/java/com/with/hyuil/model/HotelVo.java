package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class HotelVo {

	private Long id;
	private String name;
	private Long infoid;
	private Long usersid;
	private String service;
	private String bed;
	private String address;
	private String zonecode;
	private String sigungu;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;
}
