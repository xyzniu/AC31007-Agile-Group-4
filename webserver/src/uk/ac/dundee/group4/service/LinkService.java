package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.LinkDao;
import uk.ac.dundee.group4.pojo.User;

public class LinkService {

    LinkDao linkDao = new LinkDao();

    public int selectSign(User u, int examPaperId) {
        return linkDao.selectSign(u, examPaperId);
    }

    public int insertSign(User u, int examPaperId) {
        return linkDao.insertSign(u, examPaperId);
    }
}
