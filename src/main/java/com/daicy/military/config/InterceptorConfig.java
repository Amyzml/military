package com.daicy.military.config;

import com.daicy.military.core.AuthenInterceptor;
import com.daicy.military.core.OperationLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    //把我们的拦截器注入为bean
    public HandlerInterceptor getAuthenInterceptor() {
        return new AuthenInterceptor();
    }


    @Bean
    //把我们的拦截器注入为bean
    public HandlerInterceptor getOperationLogInterceptor() {
        return new OperationLogInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getAuthenInterceptor()).addPathPatterns("/**").excludePathPatterns("/error", "/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/swagger-resources/**");
        registry.addInterceptor(getOperationLogInterceptor()).addPathPatterns("/**").excludePathPatterns("/error", "/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/swagger-resources/**");
    }
}