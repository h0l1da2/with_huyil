package com.with.hyuil.dto.users;

import lombok.Data;

@Data
public class AdminJoinDto {
    private Long id;
    private String adminId;
    private String password;
    private String name;
    private String adminPwd;
}
