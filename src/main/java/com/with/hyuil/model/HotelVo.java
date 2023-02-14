package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class HotelVo {


	private long id;
	private String name;
	private long infoid;
	private long usersid;
	private String service;
	private String zonecode;
	private String sido;
	private String sigungu;
	private String address;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;
}
