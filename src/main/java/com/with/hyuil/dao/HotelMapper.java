package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.HotelVo;

@Mapper
public interface HotelMapper {
	
	void insertHotel(HotelVo hotelvo);

	HotelVo findByHotelId(long id);

}
