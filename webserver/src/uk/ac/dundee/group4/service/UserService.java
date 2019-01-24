package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UserDao;
import uk.ac.dundee.group4.pojo.User;

/**
 * This is a Service dealing with users.
 */
public class UserService {
    UserDao userDao = new UserDao();

    /**
     * querying user by username, password and staff type
     * @param username
     * @param password
     * @param type
     * @return
     */
    public User selectByUsernamePasswordAndType(String username, String password, String type) {
        return userDao.selectByUsernamePasswordAndType(username, password, type);
    }

}
