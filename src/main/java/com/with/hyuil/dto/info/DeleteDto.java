package com.with.hyuil.dto.info;

import lombok.Data;

@Data
public class DeleteDto {

    private String userId;
    private String[] whyDelete;
    private String password;
    private String etc;
    private String privacy;
    private String otherSite;
    private String hate;
    private String joinAgain;
}
