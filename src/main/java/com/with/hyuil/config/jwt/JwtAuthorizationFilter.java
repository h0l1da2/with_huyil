package com.with.hyuil.config.jwt;

import com.with.hyuil.config.auth.PrincipalDetails;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.interfaces.UsersService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 권한이나 인증이 필요하면 얘 동작
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final String HEADER_AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer";
    private final UsersService usersService;
    private final JwtTokenParser jwtTokenParser;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UsersService usersService, JwtTokenParser jwtTokenParser) {
        super(authenticationManager);
        this.usersService = usersService;
        this.jwtTokenParser = jwtTokenParser;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 토큰 검증 후
        String token = request.getHeader(HEADER_AUTHORIZATION);
        boolean accessToken = jwtTokenParser.tokenValidation(token);
        if(accessToken) {
            Authentication authentication = createAuthentication(token);
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private Authentication createAuthentication(String token) {
        String username = jwtTokenParser.usernameByToken(token);
        UsersVo usersVo = usersService.loginForFind(username);
        PrincipalDetails principalDetails = new PrincipalDetails(usersVo);
        return new UsernamePasswordAuthenticationToken(
                principalDetails, username, principalDetails.getAuthorities());
    }
}
