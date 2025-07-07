package com.realtime.editor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:3000") // Allow React app to access backend
                .allowedMethods("*") // Allow all HTTP methods: GET, POST, PUT, DELETE
                .allowCredentials(true); // Allow cookies and tokens to be passed
    }
}
