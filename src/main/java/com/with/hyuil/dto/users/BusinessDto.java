package com.with.hyuil.dto.users;

import com.with.hyuil.model.BusinessVo;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BusinessDto {

    private Long id;
    private String account;
    private String bankNumber;
    private String bank;

    public BusinessDto(BusinessVo businessVo) {
        this.id = businessVo.getId();
        this.account = businessVo.getAccount();
        this.bankNumber = businessVo.getBankNumber();
        this.bank = businessVo.getBank();
    }
}
