package org.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.study.entity.Address;

import java.beans.PropertyDescriptor;

@Slf4j
@Component
@ComponentScan("org.study")
public class MyBeanPostProccesor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    @Autowired
    private Address myAddress;

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }
    }

    @Override
    public boolean requiresDestruction(Object bean) {

        return DestructionAwareBeanPostProcessor.super.requiresDestruction(bean);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass.equals(Address.class)){
            log.info("user myAddress:{}",myAddress);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Address){
            log.info("user myAddress:{}",myAddress);
        }

        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
