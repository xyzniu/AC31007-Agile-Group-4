package uk.ac.dundee.group4.dao;

import org.junit.Test;
import uk.ac.dundee.group4.util.Category;

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
}
