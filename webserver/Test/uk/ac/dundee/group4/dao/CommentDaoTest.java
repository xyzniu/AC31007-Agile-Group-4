package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.SelectComment;
import uk.ac.dundee.group4.util.Category;

import java.util.List;

/**
 * This is a test class for CommentDao
 */
public class CommentDaoTest {

    @Test
    public void insertCommentTest() {
        InsertCommentDao insertCommentDao = new InsertCommentDao();
        // insertCommentDao.InsertComment("comment", "1", "1", Category.EXAM_SETTER);
    }

    @Test
    public void selectCommentTest() {
        SelectCommentDao selectCommentDao = new SelectCommentDao();
        List<SelectComment> list = selectCommentDao.SelectComment("4");
        Assert.assertNotNull(list);
    }
}
