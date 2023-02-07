package com.with.hyuil.dto.info;

import com.with.hyuil.model.enumaration.Status;
import lombok.Data;

@Data
public class BookSearchDto {
    private Long userId;
    private int viewPage = 1;
    private int limit = 6;
    private int nowPage;
    private Status status;

    public BookSearchDto() {
    }

    public void calcPage(int beginPage) {
        this.nowPage = viewPage;
        this.viewPage = viewPage == 1 ? 1 : beginPage;
        this.limit = limit > this.viewPage+5 ? limit : this.viewPage+5;
    }
}
