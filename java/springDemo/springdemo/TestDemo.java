package springDemo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(AppConfig.class);
        AutoConfigurationController demo = (AutoConfigurationController) a.getBean("autoConfigurationController");
        try {
            demo.demo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
