package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.dto.hotel.StarDto;
import com.with.hyuil.model.HotelVo;

import java.util.List;

public interface HotelService {

    void addHotel(HotelVo hotelvo);
    List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto);
    List<StarDto> searchHotelStar(List<HotelListDto> hotelListDtos);
    HotelVo findByHotelUserId(Long userId);
    HotelVo findByHotelId(long id);
    void updateHotel(HotelVo hotelvo);
    HotelVo getRoomId(long id);
    long getHostId(long id);
    void delHotel(HotelVo hotelvo);
}
