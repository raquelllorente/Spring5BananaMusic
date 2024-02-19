package com.bananaapps.bananamusic.config;

import com.bananaapps.bananamusic.interceptor.OrderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class OrderInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    OrderInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/order");
    }
}
