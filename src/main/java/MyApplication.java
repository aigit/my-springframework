import org.ldl.study.config.UserConfig;
import org.ldl.study.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        try{
            AnnotationConfigApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(UserConfig.class);
            User user = (User) applicationContext.getBean("user");
            System.out.println("x"+user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
