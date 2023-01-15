package com.with.hyuil.model;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class UsersVo {

    private Long id;
    private String userId;
    private String password;
    @Email
    private String email;
    private String tel;
    private String name;
    private Wheres wheres;
    private Role role;

    protected UsersVo() {}

    public UsersVo(String userId, String password, String email, String tel, String name, Wheres wheres, Role role) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.name = name;
        this.wheres = wheres;
        this.role = role;
    }
}
