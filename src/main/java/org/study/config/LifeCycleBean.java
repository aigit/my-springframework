package org.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Slf4j
//@Component
public class LifeCycleBean {

    /*@Resource
    private UserConfig userConfig;*/


    public LifeCycleBean(){
        log.info("LifeCycleBean构造");
    }

    @Autowired
    public void autowired(@Value("${user.name}") String userName){
        log.info("autowired:{}",userName);
    }

    @PostConstruct
    public void init(){
        log.info("init,user:{}");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("preDestroy");
    }
}
