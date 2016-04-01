package kr.ac.jejunu.test;

import kr.ac.jejunu.DaoFactory;
import kr.ac.jejunu.User;
import kr.ac.jejunu.UserDao;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Kim on 2016-03-25.
 */
public class UserDaoTest {

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new DaoFactory().getUserDao();
        Long id = 1L;
        User user = userDao.get(id);

        Assert.assertEquals(user.getName(), "자바");
        Assert.assertEquals(user.getPassword(), "spring");
        Assert.assertEquals(user.getId(), id);
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        UserDao userDao = new DaoFactory().getUserDao();
        User user = new User();

        String name = "자바";
        String password = "spring";

        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);
        user.setId(id);

        Assert.assertEquals(user.getName(), name);
        Assert.assertEquals(user.getPassword(), password);
        Assert.assertEquals(user.getId(), id);
    }

}
