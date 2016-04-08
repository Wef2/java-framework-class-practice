package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim on 2016-04-01.
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new SimpleConnectionMaker();
    }

}
