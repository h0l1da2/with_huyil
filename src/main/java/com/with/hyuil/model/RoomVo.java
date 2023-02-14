package com.with.hyuil.model;

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

}
