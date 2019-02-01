package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.ExamPaperDao;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.Version;

import java.util.HashSet;
import java.util.List;

/**
 * This is a Service dealing with exam paper.
 */
public class ExamPaperService {

    ExamPaperDao dao = new ExamPaperDao();

    /**
     * querying exam papers by exam setter id
     *
     * @param examSetterId
     * @param staffName
     * @return
     */
    public List<ExamPaper> selectByExamSetter(int examSetterId, String staffName) {
        List<ExamPaper> examPapers = dao.selectByExamSetter(examSetterId);
        for (ExamPaper paper : examPapers) {
            paper.setExamSetter(staffName);
        }
        return examPapers;
    }

    /**
     * insert exam paper
     *
     * @param examPaper
     * @return
     */
    public int insertExamPaper(ExamPaper examPaper) {
        int rst = dao.insertOne(examPaper);
        return rst;
    }

    /**
     * querying url by exam paper id
     *
     * @param examPaperId
     * @return
     */
    public Version selectUrlExamPaperId(int examPaperId) {
        return dao.selectByExamPaperId(examPaperId);
    }

    /**
     * querying all exam papers
     *
     * @return
     */
    public List<ExamPaper> selectAll() {
        return dao.selectAll();
    }

    /**
     * querying exam papers by staff id and staff type
     *
     * @param id
     * @param type
     * @return
     */
    public List<ExamPaper> selectByStaffID(int id, int type) {
        return dao.selectByStaffID(id, type);

    }

    /**
     * select exampapers that have not been allocated
     *
     * @return
     */
    public List<ExamPaper> selectToAllocate() {
        return dao.selectToAllocate();
    }

    /**
     * return links
     *
     * @param id
     * @return
     */
    public List<HashSet<Integer>> selectLinkByExamPaperID(int id) {
        return dao.selectLinkByExamPaperID(id);
    }

}
