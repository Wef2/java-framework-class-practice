package kr.ac.jejunu.test;

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
    public void test() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.get(1L);

        Assert.assertEquals(user.getName(), "test");
        Assert.assertEquals(user.getPassword(), "test1");
        Assert.assertEquals(user.getId(), "1L");
    }
}
