package com.with.hyuil.config;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.with.hyuil.config.auth.CustomOAuth2UserService;
import com.with.hyuil.config.auth.CustomUserDetailsService;
import com.with.hyuil.config.handler.AuthenticationExceptionHandler;
import com.with.hyuil.config.handler.UserLoginFailureHandler;
import com.with.hyuil.config.handler.UserLoginSuccessHandler;
=======
import com.with.hyuil.config.auth.CustomUserDetailsService;
import com.with.hyuil.config.auth.JwtAuthenticationEntryPoint;
import com.with.hyuil.config.jwt.JwtRequestFilter;
import com.with.hyuil.config.jwt.JwtTokenProvider;
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.service.UsersServiceImpl;
import com.with.hyuil.service.interfaces.UsersService;
=======
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)
=======
import com.with.hyuil.config.auth.CustomUserDetailsService;
import com.with.hyuil.config.jwt.JwtRequestFilter;
import com.with.hyuil.config.jwt.JwtTokenProvider;
import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.service.UsersServiceImpl;
import com.with.hyuil.service.interfaces.UsersService;
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
=======
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
=======
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)
=======
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private final UsersMapper usersMapper;
    private final AuthenticationExceptionHandler authenticationExceptionHandler;
    @Bean
    public DefaultOAuth2UserService defaultOAuth2UserService() {
        return new CustomOAuth2UserService(usersService());
=======
=======
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersMapper usersMapper;
    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersMapper, bCryptPasswordEncoder());
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(usersService());
<<<<<<< HEAD
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
    }
=======
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)
=======
    }
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersMapper, bCryptPasswordEncoder());
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(usersService());
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder())
        ;
    }

=======
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder())
                ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder())
                ;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
<<<<<<< HEAD
=======

=======

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)

        http
                .csrf().disable()
                .httpBasic().disable()

                .authorizeRequests()
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

                .mvcMatchers("/users/**")
                .hasRole("USER")
                .mvcMatchers("/user/info/**")
                .hasAnyRole("USER", "HOST")
=======
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
                .mvcMatchers("/hosts/**")
                .hasAnyRole("HOST", "ADMIN")
                .mvcMatchers("/admin/**")
                .hasRole("ADMIN")
<<<<<<< HEAD
=======
=======
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
//                .mvcMatchers("/hosts/**")
//                .hasAnyRole("HOST", "ADMIN")
//                .mvcMatchers("/admin/**")
//                .hasRole("ADMIN")
<<<<<<< HEAD
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
=======
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
=======
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
                .anyRequest()
                .permitAll()

                .and()
<<<<<<< HEAD
<<<<<<< HEAD
                .formLogin()
                .loginPage("/host/loginForm")
<<<<<<< HEAD
                .loginPage("/user/loginForm")
=======
                .defaultSuccessUrl("/host")

                .and()
                .formLogin()
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
                .loginPage("/admins")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler(new UserLoginSuccessHandler(usersService()))
                .failureHandler(new UserLoginFailureHandler())
                .permitAll()

                .and()
<<<<<<< HEAD
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationExceptionHandler)

                .and()
                .oauth2Login()
                .loginPage("/user/loginForm")
                .successHandler(new UserLoginSuccessHandler(usersService()))
                .failureHandler(new UserLoginFailureHandler())
                .userInfoEndpoint()
                .userService(defaultOAuth2UserService())
=======
                .addFilterBefore(new JwtRequestFilter(jwtTokenProvider, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
=======
                .addFilterBefore(new JwtRequestFilter(jwtTokenProvider, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
>>>>>>> c49688c (LoginService 추가해서 Controller 수정)
        ;
=======
                .formLogin()
                .loginPage("/user/loginForm")
                .loginProcessingUrl("/user/login")
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)

                .and()
                .formLogin()
                .loginPage("/host/loginForm")
                .defaultSuccessUrl("/host")

                .and()
                .formLogin()
                .loginPage("/admins")
                .loginProcessingUrl("/admins/login")
                .defaultSuccessUrl("/")

                .and()
                .addFilterBefore(new JwtRequestFilter(jwtTokenProvider, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring() // 정적파일들 필터 검사 ㄴㄴ
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                .mvcMatchers("/resources/static/**")
        ;
=======
                .mvcMatchers("/static/**")
=======
                .antMatchers("/resources/static/**")
>>>>>>> ea333e3 (JWT 토큰 만들기 위한 base 클래스들)
=======
                .mvcMatchers("/static/**")
>>>>>>> e2072f0 (User 로그인 JWT 토큰 반환 완성)
                ;
>>>>>>> 317a2e1 (User 로그인 JWT 토큰 반환 완성)
    }
}