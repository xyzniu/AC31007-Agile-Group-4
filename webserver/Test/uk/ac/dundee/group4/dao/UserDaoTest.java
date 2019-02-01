package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a test class for UserDao
 */
public class UserDaoTest {

    UserDao dao = new UserDao();

    @Test
    public void selectStaff() {
        List<List<User>> lists = dao.selectStaff();
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    @Test
    public void insertLink() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);

        dao.insertLink(list1, list2, list3, 1);
    }

    @Test
    public void selectByUsernamePasswordAndType() {
        User u = new User();
        u.setUsername("examsetter1@dundee.ac.uk");
        u.setPassword("password");
        u.setStaffType(Category.EXAM_SETTER);
        User user = dao.selectByUsernamePasswordAndType(u.getUsername(), u.getPassword(), u.getStaffType());
        Assert.assertNotNull(user);
    }
}
