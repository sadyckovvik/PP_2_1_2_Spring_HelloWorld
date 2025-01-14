import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            HelloWorld bean =
                    (HelloWorld) applicationContext.getBean("helloworld");
            System.out.println(bean.getMessage());
            HelloWorld secondBean = applicationContext.getBean("helloworld", HelloWorld.class);
            Cat firstCatBean = applicationContext.getBean("cat", Cat.class);
            Cat secondCatBean = applicationContext.getBean("cat", Cat.class);
            System.out.println(bean == secondBean);
            System.out.println(firstCatBean == secondCatBean);
        }
    }
}