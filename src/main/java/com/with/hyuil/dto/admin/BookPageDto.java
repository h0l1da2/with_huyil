package com.with.hyuil.dto.admin;

import lombok.Data;

@Data
public class BookPageDto {

    private int viewPage = 1;
    private int limit = 10;
    private int nowPage;


    public void calcPage(int beginPage) {
        this.nowPage = viewPage;
        this.viewPage = viewPage == 1 ? 1 : beginPage;
        this.limit = limit > this.viewPage+9 ? limit : this.viewPage+9;
    }


}
