package kr.ac.jejunu.hello;

import org.springframework.stereotype.Component;

/**
 * Created by Kim on 2016-04-29.
 */
@Component("hello")
public class HelloImpl implements Hello {

    public String sayHello() {
        return "Hello!";
    }
}
