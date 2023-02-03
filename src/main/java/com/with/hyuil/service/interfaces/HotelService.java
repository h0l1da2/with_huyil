package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.model.HotelVo;

import java.util.List;

public interface HotelService {

    void addHotel(HotelVo hotelvo);
    List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto);
	HotelVo findByHotelId(long id);
    

}
