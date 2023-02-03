
package com.with.hyuil.service;

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
	
}
