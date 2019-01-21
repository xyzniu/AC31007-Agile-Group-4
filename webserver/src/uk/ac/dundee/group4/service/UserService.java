package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UserDao;
import uk.ac.dundee.group4.pojo.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    public List<User> selectAll(){
        return userDao.selectAll();
    }
}
