package com.with.hyuil.config;

//import com.with.hyuil.config.jwt.HostAuthenticationProvider;
import com.with.hyuil.config.jwt.JwtAuthenticationFilter;
import com.with.hyuil.config.jwt.JwtTokenParser;
import com.with.hyuil.config.jwt.JwtTokenProvider;
import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.service.UsersServiceImpl;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenParser jwtTokenParser;
    private final UsersMapper usersMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersMapper, bCryptPasswordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider);
        jwtAuthenticationFilter.setFilterProcessesUrl("/user/login");
        return jwtAuthenticationFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .httpBasic()
                .disable()

                .authorizeRequests()
                .antMatchers("/hosts/**")
                .access("hasRole('HOST') or hasRole('ADMIN')")
                .antMatchers("/admin/**")
                .access("hasRole('ADMIN')")
                .anyRequest()
                .permitAll()

                .and()
                .formLogin()
                .loginPage("/user/loginForm")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/")

                .and()
                .formLogin()
                .loginPage("/host/loginForm")
//                .successHandler(hostAuthenticationProvider)
//                .failureHandler()
                .defaultSuccessUrl("/host")

                .and()
                .formLogin()
                .loginPage("/admins")
                .loginProcessingUrl("/admins/login")
                .defaultSuccessUrl("/")

                .and()
                .addFilterBefore(jwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring() // 정적파일들 필터 검사 ㄴㄴ
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
