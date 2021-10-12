import lombok.extern.slf4j.Slf4j;
import org.ldl.study.config.UserConfig;
import org.ldl.study.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MyApplication {
    public static void main(String[] args) {
        try{
            AnnotationConfigApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(UserConfig.class);
            User user = (User) applicationContext.getBean("user");
            log.info("name:{},city:{},{}",user.getName(),user.getAddress().getProvince(),
                    user.getAddress().getCity());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
