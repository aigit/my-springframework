package org.study.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class MyProxyHandler implements InvocationHandler {

    private Object target;

    public MyProxyHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoked = method.invoke(target, args);
        log.info("after invoked");
        return invoked;
    }
}
