package org.study.config;

import org.springframework.context.annotation.Import;
import org.study.dao.impl.UserDaoImpl;
import org.study.entity.Address;
import org.study.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.service.IScoreCounter;
import org.study.service.impl.ScoreCounterService;

@Configuration
@ComponentScan("org.ldl.study")
@Import({ScoreCounterService.class, UserDaoImpl.class})
public class UserConfig {

    @Bean
    public User getUser(){
        return new User();
    }

    @Bean
    public Address myAddress(){
        Address address = new Address();
        address.setCity("青岛");
        address.setProvince("山东");
        return address;
    }
}
