package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.SelectComment;
import uk.ac.dundee.group4.util.Category;

import java.util.List;

/**
 * This is a test class for SelectCommentDao
 */
public class CommentDaoTest {

    /**
     * test for selectCommentDao
     */
    @Test
    public void selectCommentTest() {
        SelectCommentDao selectCommentDao = new SelectCommentDao();
        List<SelectComment> list = selectCommentDao.SelectComment("4");
        Assert.assertNotNull(list);
    }
}
