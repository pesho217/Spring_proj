package spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Person;


@RestController
public class DefaultController {

    @GetMapping("/webapplication")
    public String web(){
        return "Hello web!";
    }
    @GetMapping("/test")
    public String root(){
        return "Hello from Spring!";
    }

    @PostMapping("/test")
    public String posting(@RequestBody Person person){
        return "You just posted person to me!";
    }

}
