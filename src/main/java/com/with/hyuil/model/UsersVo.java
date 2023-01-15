package com.with.hyuil.model;

import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.model.enumaration.Wheres;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime out;
    private BusinessVo businessVo;


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

    public UsersVo(UsersDto usersDto) {
        this.userId = usersDto.getUserId();
        this.password = usersDto.getPassword();
        this.email = usersDto.getEmail();
        this.tel = usersDto.getTel();
        this.name = usersDto.getName();
        this.wheres = usersDto.getWheres();
        this.role = usersDto.getRole();
        this.businessVo = usersDto.getBusinessVo();
    }

    public void hostUser(BusinessVo businessVo) {
        this.businessVo = businessVo;
    }
}
