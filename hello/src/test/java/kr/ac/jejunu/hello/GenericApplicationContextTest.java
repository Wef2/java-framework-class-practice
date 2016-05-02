package kr.ac.jejunu.hello;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by Kim on 2016-05-02.
 */
public class GenericApplicationContextTest {

    @Test
    public void applicationContext(){
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(genericApplicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("applicationContext.xml");
        genericApplicationContext.refresh();
        HelloPerson helloPerson = genericApplicationContext.getBean("helloPerson", HelloPerson.class);
        MatcherAssert.assertThat(helloPerson.sayHello(), CoreMatchers.is("Hello! Kim"));
    }
}
