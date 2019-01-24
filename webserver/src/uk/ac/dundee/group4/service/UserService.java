package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UserDao;
import uk.ac.dundee.group4.pojo.User;

public class UserService {
    UserDao userDao = new UserDao();

    public User selectByUsernamePasswordAndType(String username, String password, String type) {
        return userDao.selectByUsernamePasswordAndType(username, password, type);
    }

}
