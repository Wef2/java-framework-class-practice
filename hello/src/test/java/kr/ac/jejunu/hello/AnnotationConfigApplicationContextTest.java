package kr.ac.jejunu.hello;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kim on 2016-05-11.
 */
public class AnnotationConfigApplicationContextTest {
    @Test
    public void applicationContext() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!"));
    }

    @Test
    public void applicationContextUsingClass() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        Hello hello = applicationContext.getBean(Hello.class);
        assertThat(hello.sayHello(), is("Hello!"));
    }

    @Test
    public void applicationContextUsingDi() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        HelloPerson helloPerson = applicationContext.getBean(HelloPerson.class);
        assertThat(helloPerson.sayHello(), is("Hello! 스프링"));

    }
}
