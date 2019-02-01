package uk.ac.dundee.group4.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.util.Link;

import java.util.HashSet;
import java.util.List;

/**
 * This is a test class for ExamPaperDao.
 */
public class ExamPaperDaoTest {
    ExamPaperDao dao = new ExamPaperDao();

    /**
     * test for selectByExamSetter
     */
    @Test
    public void selectByExamSetter() {
        List<ExamPaper> examPapers = dao.selectByExamSetter(1);
        Assert.assertNotNull(examPapers);
    }

    /**
     * test for selectAll
     */
    @Test
    public void selectAll() {
        List<ExamPaper> examPapers = dao.selectAll();
        Assert.assertNotNull(examPapers);
    }

    /**
     * test for selectByExamPaperId
     */
    @Test
    public void selectByExamPaperId() {
        List<ExamPaper> list = dao.selectByExamSetter(1);
        Assert.assertNotNull(list);
    }

    /**
     * test for selectByStaffID
     */
    @Test
    public void selectByStaffID() {
        List<ExamPaper> list = dao.selectByStaffID(1, 1);
        Assert.assertNotNull(list);
    }

    /**
     * test for selectLinkByExamPaperID
     */
    @Test
    public void selectLinkByExamPaperID() {
        List<HashSet<Integer>> list = dao.selectLinkByExamPaperID(1);
        Assert.assertNotNull(list);
    }

    /**
     * test for selectToAllocate
     */
    @Test
    public void selectToAllocate(){
        List<ExamPaper> list = dao.selectToAllocate();
        Assert.assertNotNull(list);
    }



}
