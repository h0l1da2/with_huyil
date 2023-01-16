package com.with.hyuil.dto.users;

import com.with.hyuil.model.enumaration.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class AdminDto {
    private Long id;
    private String adminId;
    private String password;
    private String name;
    private LocalDateTime joinDate;
    private LocalDateTime removeDate;
    private LocalDateTime lastLogin;
    private Role role;
}
