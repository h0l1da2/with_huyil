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
	public List<StarDto> searchHotelStar(List<HotelListDto> hotelListDtos) {
		if (hotelListDtos.size() == 0) {
			HotelListDto hotelListDto = new HotelListDto();
			hotelListDto.setId(0L);
			hotelListDtos.add(hotelListDto);
		}
		return mapper.findAllStars(hotelListDtos);
	}


}

