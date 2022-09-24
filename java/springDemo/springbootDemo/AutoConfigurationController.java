package springDemo.springbootDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoConfigurationController {
    @Value("${random.int,1000}")
    private String value;
    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String demo() throws Exception {
        System.out.println(value);
        return environment.getProperty("random.int");
    }
}
