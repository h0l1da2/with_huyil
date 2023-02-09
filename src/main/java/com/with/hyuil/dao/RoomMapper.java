package com.with.hyuil.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.RoomVo;

@Mapper
public interface RoomMapper {

	void insertRoom(RoomVo roomvo);
	long roomCount(long hotelId);
	List<Map<String, Object>> getroomList(long hotelId);
	
}
