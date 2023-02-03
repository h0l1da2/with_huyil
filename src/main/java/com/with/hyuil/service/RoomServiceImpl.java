<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
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
<<<<<<< HEAD

	public List<Map<String, Object>> getroomList(long hotelId){
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		try {
			roomList = mapper.getroomList(hotelId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roomList;
	}

	public RoomVo getRoom(long hotelId) {
		return mapper.getRoom(hotelId);
	}

}
=======
	
}
=======

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
>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
