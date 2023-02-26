package com.with.hyuil.service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.dto.review.StarDto;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return mapper.selectForHotelList(hotelSearchDto);
	}
	
	@Override
	public void updateHotel(HotelVo hotelvo) {
		mapper.updateHotel(hotelvo);
	}
	
	@Override
	public HotelVo getRoomId(long id) {
		return mapper.findByRoomId(id);
	}
	
	@Override
	public long getHostId(long id) {
		return mapper.findHostId(id);
	}
	
	@Override
	public void delHotel(HotelVo hotelvo) {
		mapper.delHotel(hotelvo);
	}

	@Override
	public Integer allHotelCnt() {
		return mapper.selectAllCnt();
	}

	@Override
	public Integer allHotelCnt() {
		return mapper.selectAllCnt();
	}

	@Override
	public List<StarDto> searchHotelStar(List<HotelListDto> hotelListDtos) {
		try {
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

