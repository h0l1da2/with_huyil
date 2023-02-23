package com.with.hyuil.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrdersVo {

	private long id;
	private long userId;
	private int totalPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private LocalDate checkin;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private LocalDate checkout;
	private long hostId;
	private String tid;
	private String userName;
	private String hotel;
	private String room;
	private String pgToken;
	
}