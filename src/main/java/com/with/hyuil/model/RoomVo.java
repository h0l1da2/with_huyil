package com.with.hyuil.model;

import lombok.Data;

@Data
public class RoomVo {
	
	private long id;
	private long hotel_id;
	private String name;
	private String content;
	private int max;
	private String bed;
	private int n_price;
	private int h_price;
	private long admin_id;

}
