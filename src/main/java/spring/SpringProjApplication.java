package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class SpringProjApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringProjApplication.class, args);
        System.out.println(context.getClass());
    }

}
