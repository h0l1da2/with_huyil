package com.with.hyuil.dto.info;

import java.util.Date;

import com.with.hyuil.model.enumaration.Status;

import lombok.Data;

@Data
public class BookAddDto {

	private Long id;
    private Long userId;
    private Long roomId;
    private String please;
    private Integer count;
    private Date checkIn;
    private Date checkOut;
    private Status status;
    private Long orderId;
    
}