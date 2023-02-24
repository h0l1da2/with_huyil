package com.with.hyuil.model;

public class PayCompleteVo {

	String userId, userName, day, pg_token, item;

	public PayCompleteVo(String userId, String userName, String day, String pg_token, String item) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.day = day;
		this.pg_token = pg_token;
		this.item = item;
	}

	public PayCompleteVo() {
		super();
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPg_token() {
		return pg_token;
	}

	public void setPg_token(String pg_token) {
		this.pg_token = pg_token;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}
