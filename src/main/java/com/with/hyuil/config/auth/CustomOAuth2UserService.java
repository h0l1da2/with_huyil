package com.with.hyuil.config.auth;

import com.with.hyuil.config.auth.sns.GoogleUserInfo;
import com.with.hyuil.config.auth.sns.KakaoUserInfo;
import com.with.hyuil.config.auth.sns.NaverUserInfo;
import com.with.hyuil.config.auth.sns.SnsUserInfo;
import com.with.hyuil.model.RolesVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.enumaration.Type;
import com.with.hyuil.model.enumaration.Wheres;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UsersService usersService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("클라이언트 = {}",userRequest.getClientRegistration());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        SnsUserInfo userInfo = null;
        String client = userRequest.getClientRegistration().getRegistrationId();
        if(client.equals("google")) {
            userInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }
        if(client.equals("naver")) {
            userInfo = new NaverUserInfo(
                    (Map<String, Object>) oAuth2User.getAttributes().get("response"));
        }
        if(client.equals("kakao")) {
            userInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        }

        Wheres provider = userInfo.getProvider();
        String providerId = userInfo.getProviderId();
        String phone = userInfo.getPhone();
        String username = provider + "_" + providerId;
        String password = username+providerId+ UUID.randomUUID();
        String email = userInfo.getEmail();
        String sns = client.toUpperCase();
        UsersVo usersVo = usersService.loginForFind(username);

        if (usersVo == null) {
            log.info("SNS 가입");

            UsersVo newUser = UsersVo.builder()
                    .userId(username)
                    .password(password)
                    .email(email)
                    .tel(phone)
                    .name("SNS_NONE")
                    .wheres(Wheres.valueOf(sns))
                    .type(Type.USER)
                    .build();

            usersService.saveUser(newUser);
            UsersVo usersVo1 = usersService.loginForFind(newUser.getUserId());
            RolesVo rolesVo = usersService.roleForLogin(usersVo1.getId());
            usersVo1.myRole(rolesVo);
            return new CustomUserDetails(usersVo1, oAuth2User.getAttributes());
        }
        RolesVo rolesVo = usersService.roleForLogin(usersVo.getId());
        usersVo.myRole(rolesVo);
        return new CustomUserDetails(usersVo, oAuth2User.getAttributes());
    }

}
