package com.example.web_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Swagger ve API dokümantasyonu yolları tamamen açık
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-ui/index.html",
                                "/webjars/**"
                        ).permitAll()
                        // Diğer tüm endpointler açık (auth yok)
                        .anyRequest().permitAll()
                )
                // HTTP Basic veya login ekranını devre dışı bırak
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable())
                // CSRF devre dışı (Swagger UI testleri için gerekli)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}