package uk.ac.dundee.group4.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for Category Test
 */
public class CategoryTest {

    @Test
    public void test() {
        Assert.assertEquals(Category.EXAM_SETTER, "ExamSetter");
        Assert.assertEquals(Category.SCHOOL_OFFICE, "SchoolOffice");
        Assert.assertEquals(Category.INTERNAL_MODERATOR, "InternalModerator");
        Assert.assertEquals(Category.EXTERNAL_EXAMINER, "ExternalExaminer");
        Assert.assertEquals(Category.EXAM_VETTING_COMMITTEE, "ExamVettingCommittee");

        Assert.assertEquals(Category.PAPER_EXAM, 0);
        Assert.assertEquals(Category.ONLINE_EXAM, 1);
        Assert.assertEquals(Category.MAIN_EXAM, 0);
        Assert.assertEquals(Category.RECITE_EXAM, 1);
        Assert.assertEquals(Category.UNDERGRADUATE_EXAM, 0);
        Assert.assertEquals(Category.POSTGRADUATE_EXAM, 1);

        Assert.assertEquals(Category.TO_SIGN_BY_INTERNAL_MODERATOR, 0);
        Assert.assertEquals(Category.TO_SIGN_BY_EXAM_VETTING_COMMITTEE, 1);
        Assert.assertEquals(Category.TO_SIGN_BY_EXTERNAL_EXAMINER, 2);
        Assert.assertEquals(Category.DONE, 3);

    }
}
