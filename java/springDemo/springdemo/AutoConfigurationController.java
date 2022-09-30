package springDemo.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class AutoConfigurationController {
    @Autowired
    private User User;

    public void demo() throws Exception {
        System.out.println(User);
    }
}
