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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)

    public RolesVo(Long id, Role roleName, Long userId) {
        this.id = id;
        this.roleName = roleName;
        this.usersVo = new UsersVo(userId);
    }
<<<<<<< HEAD
=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
}
