
package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.RoomVo;

@Mapper
public interface RoomMapper {

	void insertRoom(RoomVo roomvo);
	
}
