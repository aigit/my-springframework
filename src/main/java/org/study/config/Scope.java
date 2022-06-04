package org.study.config;

import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.AnnotationUtils;
import org.study.entity.Address;

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Scope {

    public static void main(String[] args) {
    }
}
