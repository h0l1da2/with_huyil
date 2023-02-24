package com.with.hyuil.dao;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.dto.review.StarDto;
import com.with.hyuil.model.HotelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {
	void insertHotel(HotelVo hotelvo);
	List<HotelListDto> selectForHotelList(HotelSearchDto hotelSearchDto);
	List<StarDto> findAllStars(List<HotelListDto> hotelListDtos);
	HotelVo findByHotelId(long id);
	HotelVo findByHoteluserId(Long userId);
	int selectCntForHotelList(HotelSearchDto hotelSearchDto);
	Integer selectAllCnt();
	void updateHotel(HotelVo hotelvo);
	HotelVo findByRoomId(long id);
	long findHostId(long id);
	void delHotel(HotelVo hotelvo);
}