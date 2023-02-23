package com.with.hyuil.dto.admin;

import com.with.hyuil.model.enumaration.Out;
import lombok.Data;

@Data
public class AdminUserListDto {
    private Long id;
    private String userId;
    private String name;
    private String email;
    private String tel;
    private String account;
    private String JoinDate;
    private String lastLogin;
    private Out out;
    private Integer totcnt;
}
