package com.with.hyuil.config.auth.sns;


import com.with.hyuil.model.enumaration.Wheres;

import java.util.Map;

public class KakaoUserInfo implements SnsUserInfo {

    private Map<String, Object> attributes; //oAuth2User.getAttributes
    private Map<String, Object> attributesAccount;
    private Map<String, Object> attributesProfile;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.attributesAccount = (Map<String, Object>) attributes.get("kakao_account");
        this.attributesProfile = (Map<String, Object>) attributesAccount.get("profile");
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public Wheres getProvider() {
        return Wheres.KAKAO;
    }

    @Override
    public String getEmail() {
        return String.valueOf(attributesAccount.get("email"));
    }

    @Override
    public String getName() {
        return String.valueOf(attributesProfile.get("nickname"));
    }

    @Override
    public String getPhone() {
        return "NONE";
    }
}
