package com.with.hyuil.dto.users;

import com.with.hyuil.model.enumaration.Role;
<<<<<<< HEAD
<<<<<<< HEAD
import com.with.hyuil.model.enumaration.Type;
=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
import com.with.hyuil.model.enumaration.Type;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
    private Long businessId;
    private String account; //사업자번호
    private String bNumber;
    private String bank;
    private Type type;
<<<<<<< HEAD
=======
    private String account; //사업자번호
    private String bNumber;
    private String bank;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))

}
