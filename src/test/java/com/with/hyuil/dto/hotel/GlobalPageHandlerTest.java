package com.with.hyuil.dto.hotel;

import com.with.hyuil.dto.info.BookSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class GlobalPageHandlerTest {
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
        int totalPost = 3;
        int viewPage = 1;
        BookSearchDto bookSearchDto = new BookSearchDto();
        bookSearchDto.setViewPage(viewPage);
        bookSearchDto.setLimit(totalPost);
        log.info("북서치디티오 = {}", bookSearchDto);
//        bookSearchDto.calcPage();
        log.info("다시 북서치 디티오 = {}", bookSearchDto);
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(totalPost, viewPage);
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