package com.with.hyuil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig extends CorsFilter {

    public CorsConfig(CorsConfigurationSource configSource) {
        super(configSource);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답할 때, json을 자바스크립트에서 처리할 수 있게 할까? jquery ajax ...
        config.addAllowedOriginPattern("*"); // 모든 ip에 응답을 허용할게
        config.addAllowedHeader("*"); // 모든 헤더에 응답을 허용할게
        config.addAllowedMethod("*"); // 모든 post, get, put, delete ...등에서의 요청을 허용할게
        source.registerCorsConfiguration("/api/**", config);


        return new CorsFilter(source);
    }
}
