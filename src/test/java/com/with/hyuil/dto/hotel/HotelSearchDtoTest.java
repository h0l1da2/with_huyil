package com.with.hyuil.dto.hotel;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
class HotelSearchDtoTest {

    @Test
    void dateTest() throws ParseException {
        String birthDate = "1997-11-19";
//현재 날짜의 타입
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//Date로 파싱
        Date birth = dateFormat.parse(birthDate);
//변경할 타입으로의 형 변환
        String processDate = new SimpleDateFormat("yyyy-MM-dd").format(birth);

        log.info("birth = {}", birth);
        log.info("processDate = {}", processDate);
    }

}