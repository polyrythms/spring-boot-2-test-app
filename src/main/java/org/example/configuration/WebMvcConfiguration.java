package org.example.configuration;

import org.example.controller.CustomInterceptor;
import org.example.controller.TestCustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/api/operation/**");
        registry.addInterceptor(new TestCustomInterceptor()).addPathPatterns("/api/test/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
