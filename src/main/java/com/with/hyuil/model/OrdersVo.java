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
	private LocalDate checkin;
	private LocalDate checkout;
	private long payCompleteId;
	
}
