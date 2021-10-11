package org.ldl.study.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    @Value("孙悟空")
    private String name;
    private int age;
    private Address address;
}
