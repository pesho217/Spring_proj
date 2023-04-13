package spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringProjController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}
