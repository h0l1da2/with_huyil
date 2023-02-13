package com.with.hyuil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.RoomMapper;
import com.with.hyuil.model.RoomVo;

@Service
public class RoomServiceImpl {

	@Autowired
	private RoomMapper mapper;
	
	public void addRoom(RoomVo roomvo) {
		mapper.insertRoom(roomvo);
	}
	
	public List<Map<String, Object>> getroomList(long hotelId){
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		try {
			roomList = mapper.getroomList(hotelId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roomList;
	}
	
}