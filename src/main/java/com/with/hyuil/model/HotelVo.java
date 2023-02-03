<<<<<<< HEAD
<<<<<<< HEAD
package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class HotelVo {


	private long id;
	private String name;
	private long infoid;
	private long usersid;
	private String service;
	private String zonecode;
	private String sido;
	private String sigungu;
	private String address;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;
}
=======
package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class HotelVo {

	private Long id;
	private String name;
	private Long infoid;
	private Long usersid;
	private String service;
	private String bed;
	private String address;
	private String zonecode;
	private String sigungu;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;
}
>>>>>>> 5210103 (add : 호텔 등록 관련, 시큐리티 로그인 관련 (#16))
=======
package com.with.hyuil.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class HotelVo {


	private long id;
	private String name;
	private long infoid;
	private long usersid;
	private String service;
	private String zonecode;
	private String sido;
	private String sigungu;
	private String address;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;
}
>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
