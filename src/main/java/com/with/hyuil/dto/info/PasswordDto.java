package com.with.hyuil.dto.info;

import lombok.Data;

@Data
public class PasswordDto {

    private String userId;
    private String password;
    private String newPassword;

    public PasswordDto() {
    }

    public PasswordDto(String userId, String password, String newPassword) {
        this.userId = userId;
        this.password = password;
        this.newPassword = newPassword;
    }
}
