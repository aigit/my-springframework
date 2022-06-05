package org.study.mvc.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @PostMapping("one")
    public String one(){
        return "1";
    }

    @RequestMapping("two")
    public String two(){
        return "2";
    }

}
