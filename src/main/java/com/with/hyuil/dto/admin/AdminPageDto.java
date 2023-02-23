package com.with.hyuil.dto.admin;

import com.with.hyuil.model.enumaration.Type;
import lombok.Data;

@Data
public class AdminPageDto {

    private int viewPage = 1;
    private int limit = 10;
    private int nowPage;
    private Type type;


    public void calcPage(int beginPage) {
        this.nowPage = viewPage;
        this.viewPage = viewPage == 1 ? 1 : beginPage;
        this.limit = limit > this.viewPage+9 ? limit : this.viewPage+9;
    }


}
