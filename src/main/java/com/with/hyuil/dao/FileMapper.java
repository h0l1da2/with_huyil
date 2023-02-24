package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.FileVo;

@Mapper
public interface FileMapper {

	void uploadFile(FileVo filevo);
	FileVo selecthotelImg(long hotelInfoId);
	FileVo selectRoomImg(long roomId);
	void deleteHotelImg(FileVo filevo);
	void deleteRoomImg(FileVo filevo);
}