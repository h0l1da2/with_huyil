package com.with.hyuil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.model.HotelVo;

@Service
public class HotelServiceImpl {

	@Autowired
	private HotelMapper mapper;
	
	public void addHotel(HotelVo hotelvo) {
		mapper.insertHotel(hotelvo);
	}
	
}
