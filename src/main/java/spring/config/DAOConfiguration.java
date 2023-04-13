package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dao.DBUserDao;
import spring.dao.IUserDao;

@Configuration
public class DAOConfiguration {

    @Bean
    public IUserDao dbUserdao(){
        return new DBUserDao();
    }


}
