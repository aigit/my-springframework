package org.study.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Address {

    private String province;
    private String city;
}
