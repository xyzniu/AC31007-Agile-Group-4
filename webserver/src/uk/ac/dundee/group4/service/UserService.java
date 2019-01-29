package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UserDao;
import uk.ac.dundee.group4.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Service dealing with users.
 */
public class UserService {
    UserDao userDao = new UserDao();

    /**
     * querying user by username, password and staff type
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    public User selectByUsernamePasswordAndType(String username, String password, String type) {
        return userDao.selectByUsernamePasswordAndType(username, password, type);
    }

    /**
     * querying users including internal moderator, committee member, and external moderator
     *
     * @return
     */
    public List<List<User>> selectStaff() {
        return userDao.selectStaff();
    }

    public int insertLink(String[] internalModerators, String[] committeeMembers, String[] externalModerators, int examPaperId) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < internalModerators.length; i++) {
            list1.add(Integer.parseInt(internalModerators[i]));
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < committeeMembers.length; i++) {
            list2.add(Integer.parseInt(committeeMembers[i]));
        }
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < externalModerators.length; i++) {
            list3.add(Integer.parseInt(externalModerators[i]));
        }
        return userDao.insertLink(list1, list2, list3, examPaperId);
    }

}
