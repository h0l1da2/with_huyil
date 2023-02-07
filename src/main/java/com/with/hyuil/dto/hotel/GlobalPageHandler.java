package com.with.hyuil.dto.hotel;

import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class GlobalPageHandler {
    private final int postCount = 6; // 화면에 보여줄 게시글 갯수
    private final int listSize = 5; // 목록 갯수
    private int totalPost; //총 글 갯수
    private int totalPage; //총 페이지 갯수 *
    private int offsetPost; //페이지 첫 글
    private int limitPost; //페이지 마지막 글
    private int viewPage; //현재 페이지
    private int beginPage; //목록 첫 페이지
    private int endPage; //목록 마지막 페이지

    private boolean showNext = false;
    private boolean showPrev = false;

    public GlobalPageHandler(int totalPost, int viewPage) {
        this.totalPost = totalPost;
        this.viewPage = viewPage;

        totalPage = totalPost% postCount == 0 ? totalPost/ postCount : totalPost/ postCount +1;
        limitPost = viewPage* postCount < totalPost ? viewPage* postCount : totalPost;
        offsetPost = viewPage* postCount -5;
        beginPage = (viewPage/ postCount *(postCount -1))+1;
        endPage = totalPost*0.1 >= 0.6 ? totalPage : beginPage+listSize -1;

        showNext = totalPage != endPage;
        showPrev = beginPage != 1;

    }

    public String getPageInfo(Integer viewPage) {
        return UriComponentsBuilder.newInstance()
                .queryParam("viewPage", viewPage)
                .queryParam("totalPost", totalPost)
                .build().toString();
    }
}
