package com.with.hyuil.config.auth.sns;

import com.with.hyuil.model.enumaration.Wheres;

public interface SnsUserInfo {

    String getProviderId(); //snsPk
    Wheres getProvider(); //sns명
    String getEmail(); //이메일
    String getName(); //이름
    String getPhone();
}
