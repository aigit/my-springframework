package org.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.study.config.MyBeanPostProccesor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.mvc.config.MyRequestHandlerMappingAdapter;
import org.study.mvc.config.Webconfig;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

@Slf4j
@SpringBootApplication
public class MyApplication {



    public static void main(String[] args) {
        try{
            /*AnnotationConfigApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(Webconfig.class);*/

            AnnotationConfigServletWebServerApplicationContext webServerApplicationContext
                    = new AnnotationConfigServletWebServerApplicationContext(Webconfig.class);

            RequestMappingHandlerMapping requestMappingHandlerMapping =
                    webServerApplicationContext.getBean(RequestMappingHandlerMapping.class);
            requestMappingHandlerMapping.getHandlerMethods().forEach((k,v)->{
                log.info("k:{}==v:{}",k,v);
            });


            final ServletContext servletContext = webServerApplicationContext.getServletContext();
            final MockHttpServletRequest request = new MockHttpServletRequest("POST","/one");

            MockHttpServletResponse response = new MockHttpServletResponse();
            HandlerExecutionChain chain = requestMappingHandlerMapping.getHandler(request);
            log.info("chain:{}",chain);
            MyRequestHandlerMappingAdapter myRequestHandlerMappingAdapter =
                    webServerApplicationContext.getBean(MyRequestHandlerMappingAdapter.class);
            final ModelAndView modelAndView = myRequestHandlerMappingAdapter.
                    invokeHandlerMethod(request, response, ((HandlerMethod) chain.getHandler()));
            log.info("modelAndView {}",modelAndView);
            //applicationContext.close();
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
            //System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
