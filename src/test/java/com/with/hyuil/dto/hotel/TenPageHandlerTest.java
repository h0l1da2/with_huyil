package com.with.hyuil.dto.hotel;

import com.with.hyuil.dto.admin.TenPageHandler;
import com.with.hyuil.dto.admin.BookPageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TenPageHandlerTest {

    @Test
    void pageTest() {
        int totalPost = 101;
        int viewPage = 10;
        TenPageHandler globalPageHandler = new TenPageHandler(totalPost, viewPage);
        BookPageDto bookPageDto = new BookPageDto();
        bookPageDto.setViewPage(viewPage);
        bookPageDto.setLimit(totalPost);
        log.info("북페이지디티오 = {}", bookPageDto);
//        bookSearchDto.calcPage();
        log.info("다시 북페이지 디티오 = {}", bookPageDto);
        log.info("총게시물 = {}", totalPost);
        log.info("지금보는페이지 = {}", viewPage);
        log.info("getTotalPost = {}", globalPageHandler.getTotalPost());
        log.info("getTotalPage = {}", globalPageHandler.getTotalPage());
        log.info("getOffsetPost = {}", globalPageHandler.getOffsetPost());
        log.info("getLimitPost = {}", globalPageHandler.getLimitPost());
        log.info("getViewPage = {}", globalPageHandler.getViewPage());
        log.info("getBeginPage = {}", globalPageHandler.getBeginPage());
        log.info("getEndPage = {}", globalPageHandler.getEndPage());
        log.info("isShowNext = {}", globalPageHandler.isShowNext());
        log.info("isShowPrev = {}", globalPageHandler.isShowPrev());
    }
}
