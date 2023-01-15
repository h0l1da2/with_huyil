package com.with.hyuil.model.users;

import lombok.Getter;

@Getter
public class BusinessVo {

    private Long id;
    private String account; //사업자번호
    private String bNumber;
    private String bank;

    protected BusinessVo() {

    }

    public BusinessVo(String account, String bNumber, String bank) {
        this.account = account;
        this.bNumber = bNumber;
        this.bank = bank;
    }
}
