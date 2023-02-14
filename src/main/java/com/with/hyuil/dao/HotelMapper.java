package com.with.hyuil.dao;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.model.HotelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HotelMapper {
	void insertHotel(HotelVo hotelvo);
	List<HotelListDto> selectForHotelList(HotelSearchDto hotelSearchDto);
	HotelVo findByHoteluserId(Long userId);
	int selectCntForHotelList(HotelSearchDto hotelSearchDto);

}