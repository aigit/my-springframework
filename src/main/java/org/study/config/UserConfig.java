package org.study.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.study.entity.Address;
import org.study.entity.User;

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
