package kr.ac.jejunu.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Kim on 2016-04-29.
 */
@Component
public class HelloPersonImpl implements HelloPerson {

    @Value("스프링")
    private String name;

    @Autowired
    private Hello hello;

    public String sayHello() {
        return hello.sayHello() + " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

}
