package org.ldl.study.config;

import org.ldl.study.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.ldl.study")
public class UserConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
