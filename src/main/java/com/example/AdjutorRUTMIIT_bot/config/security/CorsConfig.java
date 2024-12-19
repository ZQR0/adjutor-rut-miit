package com.example.AdjutorRUTMIIT_bot.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class CorsConfig {

    private final CorsPropertyContainer corsProperties;

    @Bean
    public FilterRegistrationBean<CorsFilter> filterFilterRegistrationBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin(this.corsProperties.getAllowedOrigins());
        corsConfiguration.addAllowedHeader(this.corsProperties.getAllowedHeaders());
        corsConfiguration.addExposedHeader(this.corsProperties.getExposedHeaders());
        corsConfiguration.addAllowedMethod(this.corsProperties.getAllowedMethods());
        corsConfiguration.setAllowCredentials(this.corsProperties.isAllowCredentials());

        source.registerCorsConfiguration(this.corsProperties.getPattern(), corsConfiguration);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
