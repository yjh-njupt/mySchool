package springDemo.springbootDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AutoConfigurationTest {

    @Before("execution(* springDemo.springbootDemo.AutoConfigurationController.demo())")
    public void demo1() throws Exception{
        System.out.println("AutoConfigurationTest before");
    }
}
