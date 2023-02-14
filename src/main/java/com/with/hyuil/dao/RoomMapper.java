package com.with.hyuil.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.RoomVo;

@Mapper
public interface RoomMapper {

	void insertRoom(RoomVo roomvo);
	List<Map<String, Object>> getroomList(long hotelId);
	RoomVo getRoom(long hotelId);
	RoomVo findByRoomId(long id);
}
