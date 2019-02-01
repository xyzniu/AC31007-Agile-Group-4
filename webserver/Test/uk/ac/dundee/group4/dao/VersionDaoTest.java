package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;

public class VersionDaoTest {
    VersionDao dao = new VersionDao();

    @Test
    public void updateExamPaperId() {
        int rst = dao.updateExamPaperId(2, 1);
        Assert.assertTrue(rst > 0);
    }

    @Test
    public void selectUrlbyVersionId() {
        String url = dao.selectUrlbyVersionId(1);
        Assert.assertNotNull(url);
    }
}
