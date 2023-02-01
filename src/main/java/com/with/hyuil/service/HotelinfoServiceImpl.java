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

	public HotelInfoVo findByInfoId(long hotelId) {
		return mapper.findByInfoId(hotelId);
	}

}