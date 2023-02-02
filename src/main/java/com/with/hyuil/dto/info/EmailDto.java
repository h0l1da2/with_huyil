package com.with.hyuil.dto.info;

import lombok.Data;

@Data
public class EmailDto {
    private String userId;
    private String email;
    private String newEmail;
    private String code;
}
