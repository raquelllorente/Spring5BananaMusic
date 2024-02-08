package com.bananaapps.bananamusic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepoConfig.class, ServiceConfig.class})
@ComponentScan(basePackages = {"com.bananaapps.bananamusic.persistence.music", "com.bananaapps.bananamusic.service.music"})
public class SpringConfig {


}
