package com.with.hyuil.dto.users;

import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.model.enumaration.Type;
import com.with.hyuil.model.enumaration.Wheres;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;

@Data
@RequiredArgsConstructor
public class UsersDto {
    private String userId;
    private String password;
    @Email
    private String email;
    private String tel;
    private String name;
    private Wheres wheres;
    private Long businessId;
    private String account; //사업자번호
    private String bNumber;
    private String bank;
    private Type type;

}