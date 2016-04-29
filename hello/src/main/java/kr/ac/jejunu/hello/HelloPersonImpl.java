package kr.ac.jejunu.hello;

/**
 * Created by Kim on 2016-04-29.
 */
public class HelloPersonImpl implements HelloPerson {

    private String name;
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
