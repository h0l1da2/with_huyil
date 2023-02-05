package com.with.hyuil.config.auth.sns;

import com.with.hyuil.model.enumaration.Wheres;

import java.util.Map;

public class GoogleUserInfo implements SnsUserInfo {

    private Map<String, Object> attributes; //oAuth2User.getAttributes

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("sub"));
    }

    @Override
    public Wheres getProvider() {
        return Wheres.GOOGLE;
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
        return "NONE";
    }
}
