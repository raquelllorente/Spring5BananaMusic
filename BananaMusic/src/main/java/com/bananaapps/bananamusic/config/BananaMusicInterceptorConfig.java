package com.bananaapps.bananamusic.config;

import com.bananaapps.bananamusic.interceptor.BananaMusicInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class BananaMusicInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    BananaMusicInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/order");
    }
}
