package com.example.AdjutorRUTMIIT_bot.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.mvc.cors.configs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CorsPropertyContainer {
    private String pattern;
    private String allowedOrigins;
    private String allowedHeaders;
    private String exposedHeaders;
    private String allowedMethods;
    private boolean allowCredentials;
}
