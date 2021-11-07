import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.study.config.UserConfig;
import org.study.service.IScoreCounter;
import org.study.service.impl.MyProxyHandler;
import org.study.service.impl.ScoreCounterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MyApplication {
    public static void main(String[] args) {
        try{
            AnnotationConfigApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(UserConfig.class);

            /*DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
            beanFactory.registerBeanDefinition("counterService", new AnnotatedGenericBeanDefinition(IScoreCounter.class));*/
            /*User user = (User) applicationContext.getBean("user");
            log.info("name:{},city:{},{}",user.getName(),user.getAddress().getProvince(),
                    user.getAddress().getCity());*/
            /*IScoreCounter scoreCounter = applicationContext.
                    getBean("counterProxy",IScoreCounter.class);
                   scoreCounter.add();*/
            /*IScoreCounter scoreCounter = applicationContext.getBean("counterService",
                    ScoreCounterService.class);
            MyProxyHandler proxyHandler = new MyProxyHandler(scoreCounter);
            IScoreCounter proxy = (IScoreCounter) proxyHandler.getProxy();
            proxy.add();*/

            IScoreCounter scoreCounter = applicationContext.
                    getBean("counterService",IScoreCounter.class);
            scoreCounter.add();
            log.info("time diff:{}",System.currentTimeMillis());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
