package org.ldl.study.config;

import lombok.Data;
import org.ldl.study.entity.Address;
import org.ldl.study.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
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
