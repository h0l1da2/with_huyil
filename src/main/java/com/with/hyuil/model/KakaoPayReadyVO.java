package com.with.hyuil.model;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayReadyVO {

	private String tid, next_redirect_pc_url;
	private Date created_at;
	
}