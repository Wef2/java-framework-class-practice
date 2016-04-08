package kr.ac.jejunu.test;

import kr.ac.jejunu.User;
import kr.ac.jejunu.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by Kim on 2016-03-25.
 */
public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setup(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        ApplicationContext applicationContext = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {

        Long id = 1L;
        User user = userDao.get(id);

        Assert.assertEquals(user.getName(), "자바");
        Assert.assertEquals(user.getPassword(), "spring");
        Assert.assertEquals(user.getId(), id);
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "자바";
        String password = "11";

        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);
        user.setId(id);

        Assert.assertEquals(user.getName(), name);
        Assert.assertEquals(user.getPassword(), password);
        Assert.assertEquals(user.getId(), id);
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "자바";
        String password = "spring";

        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);

        userDao.delete(id);
        User resultUser = userDao.get(id);
        Assert.assertEquals(resultUser, null);
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "자바";
        String password = "spring";

        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);
        user.setId(id);

        name = "스프링";
        password = "java";
        user.setName(name);
        user.setPassword(password);

        userDao.update(user);
        User resultUser = userDao.get(id);
        Assert.assertEquals(resultUser.getName(), "스프링");
        Assert.assertEquals(resultUser.getPassword(), "java");
    }

}