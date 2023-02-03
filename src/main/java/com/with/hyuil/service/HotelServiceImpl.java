package com.with.hyuil.service;

<<<<<<< HEAD
=======

>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d
import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.HotelMapper;
import com.with.hyuil.model.HotelVo;
import java.util.List;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d
@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper mapper;

	@Override
	public void addHotel(HotelVo hotelvo) {
		mapper.insertHotel(hotelvo);
	}
<<<<<<< HEAD
=======
	
	public HotelVo findByHotelId(Long id) {
		return mapper.findByHotelId(id);
	}


>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d
	@Override
	public List<HotelListDto> searchHotels(HotelSearchDto hotelSearchDto) {
		log.info("CheckIn = {}", hotelSearchDto.getCheckIn());
		log.info("CheckIn = {}", hotelSearchDto.getCheckOut());
		return mapper.selectForHotelList(hotelSearchDto);
	}

<<<<<<< HEAD
=======
	@Override
	public Integer searchHotelsCnt(HotelSearchDto hotelSearchDto) {
		return mapper.selectCntForHotelList(hotelSearchDto);
	}
>>>>>>> 18848e8bb8530db919ac3407e47cbd94ea23a65d

}
