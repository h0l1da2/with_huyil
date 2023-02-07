

package com.with.hyuil.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.RoomMapper;
import com.with.hyuil.model.RoomVo;

@Service
public class RoomServiceImpl {

	@Autowired
	private RoomMapper mapper;
	@Autowired
	private SqlSessionTemplate template;
	
	public void addRoom(RoomVo roomvo) {
		mapper.insertRoom(roomvo);
	}
	
	public int roomcnt(long hotel_id) {
		int count = 0;
		return template.selectOne("RoomMapper.roomCount");
	}
	
}

