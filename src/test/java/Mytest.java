import org.study.config.UserConfig;
import org.study.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = (User) applicationContext.getBean("user");
        System.out.println("x"+user.getName());
    }
}
