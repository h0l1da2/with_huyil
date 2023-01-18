package com.with.hyuil.config.jwt;

import com.with.hyuil.config.auth.PrincipalDetails;
import com.with.hyuil.model.UsersVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 로그인 요청이 오면 !
@Slf4j
@PropertySource("classpath:application.properties")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${jwt.header}")
    private String HEADER_AUTHORIZATION;
    private final JwtTokenProvider jwtTokenProvider;
    private final String BEARER = "Bearer";

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        super(authenticationManager);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 로그인 요청
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            log.info("어선티케이션시작");
            UsernamePasswordAuthenticationToken token;
            String userId = request.getParameter("userId");
            String adminId = request.getParameter("adminId");

            if (userId != null) {
                return whoRequest(request, userId);
            }
            if (adminId != null) {
                return whoRequest(request, adminId);
            }

        return null;
    }

    // 성공

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String jwtToken = jwtTokenProvider.createAccessToken(authResult);
        response.setHeader(HEADER_AUTHORIZATION, BEARER+jwtToken);
    }
    public UsernamePasswordAuthenticationToken tokenForLogin(String userId, String password) {
        return new UsernamePasswordAuthenticationToken(userId, password);
    }

    private Authentication whoRequest(HttpServletRequest request, String id) {
        UsernamePasswordAuthenticationToken token;
        token = tokenForLogin(id, request.getParameter("password"));
        // 로그인 검증을 위한 토큰
        setDetails(request, token);
        // 토큰으로 authenticate 만들어서 검증 준비 완료
        Authentication authenticate = getAuthenticationManager().authenticate(token);
        // 검증
        PrincipalDetails principal = (PrincipalDetails) authenticate.getPrincipal();
        return authenticate;
    }
}
