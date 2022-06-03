import framework.WebConfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.study.config.UserConfig;
import org.study.entity.User;

public class Mytest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = (User) applicationContext.getBean("user");
        System.out.println("x"+user.getName());
    }

    @Test
    public void testWebServerFactory(){
        AnnotationConfigServletWebServerApplicationContext serverApplicationContext =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

        System.out.println(serverApplicationContext);
    }

    public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext serverApplicationContext =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

        System.out.println(serverApplicationContext);
    }
}
