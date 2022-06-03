package org.study.config;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TemplateFactory {

    @Slf4j
    static class MyBeanFactory{
        private List<BeanProcessor> processorList =
                new ArrayList<>();
        Object getBean(){
            Object o = new Object();
            log.info("构造：{}",o);
            log.info("依赖注入:{}",o);
            processorList.forEach(p->{
                p.inject(o);
            });
            return o;
        }

        public void addBeanProcessor(BeanProcessor processor){
            processorList.add(processor);
        }

    }
    static interface BeanProcessor{
        public void inject(Object o);
    }

    public static void main(String[] args) {
        MyBeanFactory factory = new MyBeanFactory();
        factory.addBeanProcessor((f)->{
            log.info("解析 对象:{}",f);
        });

        factory.getBean();
    }

}
