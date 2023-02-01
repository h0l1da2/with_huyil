<<<<<<< HEAD
package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.HotelInfoVo;

@Mapper
public interface HotelinfoMapper {

	void insertInfo(HotelInfoVo infovo);
	HotelInfoVo findByInfoId(long hotelId);
}
=======
package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.HotelInfoVo;

@Mapper
public interface HotelinfoMapper {

	void insertInfo(HotelInfoVo infovo);
	
}
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
