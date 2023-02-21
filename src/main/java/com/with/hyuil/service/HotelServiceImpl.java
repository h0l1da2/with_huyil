package com.with.hyuil.service;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.dto.hotel.StarDto;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.model.HotelVo;

import java.util.ArrayList;
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
	
	@Override
	public void updateHotel(HotelVo hotelvo) {
		mapper.updateHotel(hotelvo);
	}

	@Override
	public List<StarDto> searchHotelStar(List<HotelListDto> hotelListDtos) {
		try {
			log.info("호텔리스트 ? = {}", hotelListDtos);
			log.info("호텔리스트 사이즈 ? = {}", hotelListDtos.size());
			if (hotelListDtos.size() == 0) {
				hotelListDtos = new ArrayList<>();
				HotelListDto hotelListDto = new HotelListDto();
				hotelListDto.setId(0L);
				hotelListDtos.add(hotelListDto);
			}
			return mapper.findAllStars(hotelListDtos);
		} catch (ArithmeticException e) {
			log.info("리뷰가 없는 게 있음");
			return null;
		}

	}


}

