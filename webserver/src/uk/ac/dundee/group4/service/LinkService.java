package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.ExamPaperDao;
import uk.ac.dundee.group4.dao.LinkDao;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.Link;

/**
 * This is a service for link table
 */
public class LinkService {

    LinkDao linkDao = new LinkDao();
    ExamPaperDao examPaperDao = new ExamPaperDao();

    /**
     * return whether the user have sign the exam paper
     *
     * @param u
     * @param examPaperId
     * @return
     */
    public int selectSign(User u, int examPaperId) {
        return linkDao.selectSign(u, examPaperId);
    }

    /**
     * sign a exam paper
     *
     * @param u
     * @param examPaperId
     * @return
     */
    public int insertSign(User u, int examPaperId) {
        int rst = linkDao.insertSign(u, examPaperId);
        int type = Link.getLink(u);
        boolean flag = linkDao.selectInOneType(type, examPaperId);
        if (flag) {
            examPaperDao.changeStage(type, examPaperId);
        }
        return linkDao.insertSign(u, examPaperId);
    }
}
