package uk.ac.dundee.group4.dao;

import org.junit.Test;
import uk.ac.dundee.group4.pojo.SelectComment;
import uk.ac.dundee.group4.util.Category;

import java.util.List;

public class CommentDaoTest {

    @Test
    public void test() {
        SelectCommentDao selectCommentDao = new SelectCommentDao();
        selectCommentDao.SelectComment("1");
    }

    @Test
    public void test2() {
        InsertCommentDao insertCommentDao = new InsertCommentDao();
        insertCommentDao.InsertComment("comment", "1", "1", Category.EXAM_SETTER);
    }

    @Test
    public void test3() {
        SelectCommentDao selectCommentDao = new SelectCommentDao();
        List<SelectComment> list = selectCommentDao.SelectComment("4");
        System.out.println(list);
    }
}
