package uk.ac.dundee.group4.dao;

import org.junit.Test;
import uk.ac.dundee.group4.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a test class for UserDao
 */
public class UserDaoTest {

    @Test
    public void selectStaffTest() {
        UserDao userDao = new UserDao();
        List<List<User>> lists = userDao.selectStaff();
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    @Test
    public void insertLink() {
        UserDao userDao = new UserDao();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);

        userDao.insertLink(list1, list2, list3, 1);
    }
}
