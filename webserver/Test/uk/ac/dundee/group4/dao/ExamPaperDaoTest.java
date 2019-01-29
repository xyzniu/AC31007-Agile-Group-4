package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.ExamPaper;

import java.util.List;

/**
 * This is a test class for ExamPaperDao.
 */
public class ExamPaperDaoTest {

    @Test
    public void selectByExamSetter() {
        ExamPaperDao dao = new ExamPaperDao();
        List<ExamPaper> examPapers = dao.selectByExamSetter(1);
        Assert.assertNotNull(examPapers);
    }

    @Test
    public void selectAll() {
        ExamPaperDao dao = new ExamPaperDao();
        List<ExamPaper> examPapers = dao.selectAll();
        Assert.assertNotNull(examPapers);
    }



}
