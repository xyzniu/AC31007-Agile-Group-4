package uk.ac.dundee.service;

import uk.ac.dundee.dao.UserDao;
import uk.ac.dundee.pojo.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    public List<User> selectAll(){
        return userDao.selectAll();
    }
}
