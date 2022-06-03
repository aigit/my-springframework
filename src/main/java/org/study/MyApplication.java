package org.ldl.study;

import lombok.extern.slf4j.Slf4j;
import org.ldl.study.config.LifeCycleBean;
import org.ldl.study.config.MyBeanPostProccesor;
import org.ldl.study.config.UserConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        try{
            AnnotationConfigApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(MyBeanPostProccesor.class);
            applicationContext.close();
            /*User user = (User) applicationContext.getBean("user");
            log.info("name:{},city:{},{}",user.getName(),user.getAddress().getProvince(),
                    user.getAddress().getCity());*/
            /*IScoreCounter scoreCounter = applicationContext.
                    getBean("counterProxy",IScoreCounter.class);
                   scoreCounter.add();*/
            /*ScoreCounterService scoreCounter = applicationContext.getBean("counterService",
                    ScoreCounterService.class);*/
            //ScoreCounterService scoreCounter = new ScoreCounterService();
            /*MyProxyHandler proxyHandler = new MyProxyHandler(scoreCounter);
            ScoreCounterService proxy = (ScoreCounterService) proxyHandler.getProxy();
            proxy.add();*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
