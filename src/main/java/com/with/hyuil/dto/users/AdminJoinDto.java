package com.with.hyuil.dto.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AdminJoinDto {
    private String userId;
    private String password;
    private String name;
    private String adminCode;
}
