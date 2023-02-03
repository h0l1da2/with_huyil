package com.with.hyuil.model;

import lombok.Getter;

@Getter
public class BusinessVo {

    private Long id;
    private String account; //사업자번호
    private String bankNumber;
    private String bank;

    protected BusinessVo() {

    }

    public BusinessVo(String account, String bankNumber, String bank) {
        this.account = account;
        this.bankNumber = bankNumber;
        this.bank = bank;
    }

}
