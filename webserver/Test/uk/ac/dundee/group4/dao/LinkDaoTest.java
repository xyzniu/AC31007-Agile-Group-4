package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.Category;

import java.sql.Connection;
import java.sql.SQLException;

public class LinkDaoTest {


    @Test
    public void connectionTest() {
        LinkDao linkDao = new LinkDao();
        Connection connection = linkDao.getConnection();
        Assert.assertNotNull(connection);
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void selectSignTest() {
        User u = new User();
        u.setId(1);
        u.setStaffType(Category.INTERNAL_MODERATOR);
        int examPaperId = 4;
        LinkDao linkDao = new LinkDao();
        int rst = linkDao.selectSign(u, examPaperId);
        Assert.assertEquals(rst, 1);
    }

    @Test
    public void insertSignTest() {
        User u = new User();
        u.setId(1);
        u.setStaffType(Category.INTERNAL_MODERATOR);
        int examPaperId = 5;
        LinkDao linkDao = new LinkDao();
        int rst = linkDao.insertSign(u, examPaperId);
        Assert.assertEquals(rst, 1);
    }
}
