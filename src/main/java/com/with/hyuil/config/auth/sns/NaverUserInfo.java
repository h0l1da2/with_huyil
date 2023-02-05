package com.with.hyuil.config.auth.sns;

import com.with.hyuil.model.enumaration.Wheres;

import java.util.Map;

public class NaverUserInfo implements SnsUserInfo {

    private Map<String, Object> attributes; //oAuth2User.getAttributes

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public Wheres getProvider() {
        return Wheres.NAVER;
    }

    @Override
    public String getEmail() {
        return String.valueOf(attributes.get("email"));
    }

    @Override
    public String getName() {
        return String.valueOf(attributes.get("name"));
    }

    @Override
    public String getPhone() {
        return String.valueOf(attributes.get("mobile"));
    }
}
