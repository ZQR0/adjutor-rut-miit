package com.example.AdjutorRUTMIIT_bot.config.security;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(@NonNull HttpSecurity http)
        throws Exception
    {

        http.authorizeHttpRequests(authz -> {
            authz.anyRequest().permitAll();
        });

        http.httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
