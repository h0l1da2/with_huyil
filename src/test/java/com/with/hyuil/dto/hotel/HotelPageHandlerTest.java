package com.with.hyuil.dto.hotel;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class HotelPageHandlerTest {
    private final int listSize = 6; // 화면에 보여줄 게시글 갯수
    private int totalPost; //총 글 갯수
    private int totalPage; //총 페이지 갯수 *
    private int offsetPost; //페이지 첫 글
    private int limitPost; //페이지 마지막 글
    private int viewPage; //현재 페이지
    private int beginPage; //목록 첫 페이지
    private int endPage; //목록 다음 페이지

    private boolean showNext = false;
    private boolean showPrev = false;
    @Test
    void page() {
        int totalPost = 120;
        int viewPage = 6;
        HotelPageHandler hotelPageHandler = new HotelPageHandler(totalPost, viewPage);
        log.info("총게시물 = {}", totalPost);
        log.info("지금보는페이지 = {}", viewPage);
        log.info("getTotalPost = {}",hotelPageHandler.getTotalPost());
        log.info("getTotalPage = {}",hotelPageHandler.getTotalPage());
        log.info("getOffsetPost = {}",hotelPageHandler.getOffsetPost());
        log.info("getLimitPost = {}",hotelPageHandler.getLimitPost());
        log.info("getViewPage = {}",hotelPageHandler.getViewPage());
        log.info("getBeginPage = {}",hotelPageHandler.getBeginPage());
        log.info("getEndPage = {}",hotelPageHandler.getEndPage());
        log.info("isShowNext = {}",hotelPageHandler.isShowNext());
        log.info("isShowPrev = {}",hotelPageHandler.isShowPrev());
    }

    @Test
    void paging() {
        totalPost = 60;
        viewPage = 1;
        int listSize = 6;

        totalPage = Math.round(totalPost/listSize);
        limitPost = viewPage*listSize < totalPost ? viewPage*listSize : totalPost;
        offsetPost = viewPage*10-9;
        beginPage = (viewPage/10*10)+1;
        endPage = totalPost*0.1 >= 1 ? totalPage : totalPost/10+1;

        showNext = totalPage != endPage;
        showPrev = beginPage != 1;
    }

}