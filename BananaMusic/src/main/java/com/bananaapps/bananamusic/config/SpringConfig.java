package com.bananaapps.bananamusic.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({ServiceConfig.class})
@ComponentScan(basePackages = "com.bananaapps.bananamusic")
@PropertySource("classpath:application.yaml")
@EnableJpaRepositories("com.bananaapps.bananamusic.persistence")
@EnableAutoConfiguration
@EntityScan("com.bananaapps.bananamusic.domain")
public class SpringConfig {


}
