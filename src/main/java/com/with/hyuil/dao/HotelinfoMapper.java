package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.HotelInfoVo;

@Mapper
public interface HotelinfoMapper {

	void insertInfo(HotelInfoVo infovo);
	HotelInfoVo findByInfoId(long hotelInfoId);
	void updateInfo(HotelInfoVo infovo);
}