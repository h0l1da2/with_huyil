package com.with.hyuil.dto.hotel;

import lombok.Data;

@Data
public class HotelSearchDto {

    private String sido;
    private Integer max;
    private String checkIn;
    private String checkOut;
    private int offset = 0;
    private final int limit = 6;

<<<<<<< HEAD

=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
=======

>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
    public HotelSearchDto(String sido, Integer max, String checkIn, String checkOut) {
        this.sido = sido;
        this.max = max;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public HotelSearchDto() {
    }

<<<<<<< HEAD

}
=======
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 78df10a (호텔 폼 / 호텔 검색 / 리스트 (#20))
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
=======

>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
}
>>>>>>> 4311133 (깃 충돌 수정중 (#24))
