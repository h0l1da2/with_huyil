package com.with.hyuil.model.users;

import com.with.hyuil.dto.users.AdminDto;
import com.with.hyuil.model.enumaration.Role;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminVo {

    private Long id;
    private String adminId;
    private String password;
    private String name;
    private LocalDateTime joinDate;
    private LocalDateTime removeDate;
    private LocalDateTime lastLogin;
    private Role role;

    protected AdminVo() {
    }

    public AdminVo(String adminId, String password, String name) {
        this.adminId = adminId;
        this.password = password;
        this.name = name;
        this.role = Role.ADMIN;
    }

    public AdminVo(AdminDto adminDto) {
        this.adminId = adminDto.getAdminId();
        this.password = adminDto.getPassword();
        this.name = adminDto.getName();
        this.role = Role.ADMIN;
    }
}
