package com.with.hyuil.dto.users;

import com.with.hyuil.model.enumaration.Type;
import com.with.hyuil.model.enumaration.Wheres;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AdminJoinDto {
    private String userId;
    private String password;
    private String name;
    private String adminCode;
    private Wheres wheres;
    private Type type;
}
