<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4311133 (깃 충돌 수정중 (#24))


package com.with.hyuil.service;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.model.HotelVo;
import java.util.List;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper mapper;

	@Override
	public void addHotel(HotelVo hotelvo) {
		mapper.insertHotel(hotelvo);
	}

	@Override
	public HotelVo findByHotelUserId(Long userId) {
		return mapper.findByHoteluserId(userId);
	}

	@Override
	public HotelVo findByHotelId(long id) {
		return mapper.findByHotelId(id);
	}

	@Override
	public List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto) {
		log.info("CheckIn = {}", hotelSearchDto.getCheckIn());
		log.info("CheckIn = {}", hotelSearchDto.getCheckOut());
		return mapper.selectForHotelList(hotelSearchDto);
	}

}
<<<<<<< HEAD
=======
>>>>>>> 78df10a (호텔 폼 / 호텔 검색 / 리스트 (#20))
=======
}
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
=======


package com.with.hyuil.service;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.model.HotelVo;
import java.util.List;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper mapper;

	@Override
	public void addHotel(HotelVo hotelvo) {
		mapper.insertHotel(hotelvo);
	}
	@Override
	public List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto) {
		log.info("CheckIn = {}", hotelSearchDto.getCheckIn());
		log.info("CheckIn = {}", hotelSearchDto.getCheckOut());
		return mapper.selectForHotelList(hotelSearchDto);
	}

}

>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
