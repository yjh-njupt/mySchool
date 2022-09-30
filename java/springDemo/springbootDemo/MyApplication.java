package springDemo.springbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MyApplication {

    public static void main1(String[] args) {
        SpringApplication.run(MyApplication.class, args);


        //new SpringApplication(MyApplication.class).run(args);
    }
}
