package com.with.hyuil.model;

import lombok.Getter;

@Getter
public class BusinessVo {

    private Long id;
    private String account; //사업자번호
<<<<<<< HEAD
    private String bankNumber;
=======
    private String bNumber;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
    private String bank;

    protected BusinessVo() {

    }

<<<<<<< HEAD
    public BusinessVo(String account, String bankNumber, String bank) {
        this.account = account;
        this.bankNumber = bankNumber;
=======
    public BusinessVo(String account, String bNumber, String bank) {
        this.account = account;
        this.bNumber = bNumber;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
        this.bank = bank;
    }

}
