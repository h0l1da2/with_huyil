package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.model.HotelVo;

import java.util.List;

public interface HotelService {

    void addHotel(HotelVo hotelvo);
    List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto);
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
	HotelVo findByHotelId(long id);
    Integer searchHotelsCnt(HotelSearchDto hotelSearchDto);
<<<<<<< HEAD
=======
>>>>>>> 78df10a (호텔 폼 / 호텔 검색 / 리스트 (#20))
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
=======

>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
}
