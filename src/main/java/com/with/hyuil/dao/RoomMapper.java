<<<<<<< HEAD
package com.with.hyuil.dao;

import java.util.List;
import java.util.Map;


=======

package com.with.hyuil.dao;

>>>>>>> 814836d (커밋)
import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.RoomVo;

@Mapper
public interface RoomMapper {

	void insertRoom(RoomVo roomvo);
<<<<<<< HEAD
	List<Map<String, Object>> getroomList(long hotelId);
	RoomVo getRoom(long hotelId);
=======
>>>>>>> 814836d (커밋)

}