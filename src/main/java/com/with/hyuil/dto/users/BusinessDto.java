package com.with.hyuil.dto.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BusinessDto {

    private Long id;
    private String account;
    private String bNumber;
    private String bank;
}
