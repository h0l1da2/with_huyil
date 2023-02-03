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
<<<<<<< HEAD
	List<HotelListDto> selectForHotelList(HotelSearchDto hotelSearchDto);
=======
	HotelVo findByHotelId(long id);
	List<HotelListDto> selectForHotelList(HotelSearchDto hotelSearchDto);
	int selectCntForHotelList(HotelSearchDto hotelSearchDto);
>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d

}
