package com.with.hyuil.dto;

import com.with.hyuil.model.Role;
import com.with.hyuil.model.Wheres;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;

@RequiredArgsConstructor
public class UserDto {
    private String userId;
    private String password;
    @Email
    private String email;
    private String tel;
    private String name;
    private Wheres wheres;
    private Role role;

}
