	package com.with.hyuil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelinfoMapper;
import com.with.hyuil.model.HotelInfoVo;

@Service
public class HotelinfoServiceImpl {

	@Autowired
	private HotelinfoMapper mapper;

	public void addInfo(HotelInfoVo infovo) {
		mapper.insertInfo(infovo);
	}

	public HotelInfoVo findByInfoId(long hotelInfoId) {
		return mapper.findByInfoId(hotelInfoId);
	}
	
	public void updateInfo(HotelInfoVo infovo) {
		mapper.updateInfo(infovo);
	}
	
	public void delInfo(HotelInfoVo infovo) {
		mapper.delInfo(infovo);
	}

}
