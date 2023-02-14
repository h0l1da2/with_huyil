package com.with.hyuil.model;

import com.with.hyuil.model.enumaration.Role;
import lombok.Getter;

@Getter
public class RolesVo {

    private Long id;
    private Role roleName;
    private UsersVo usersVo;

    public RolesVo(Role roleName, UsersVo usersVo) {
        this.roleName = roleName;
        this.usersVo = usersVo;
    }

    public RolesVo(Long id, Role roleName, Long userId) {
        this.id = id;
        this.roleName = roleName;
        this.usersVo = new UsersVo(userId);
    }
}