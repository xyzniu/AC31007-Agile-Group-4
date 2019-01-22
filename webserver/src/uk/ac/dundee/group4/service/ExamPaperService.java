package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.ExamPaperDao;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.Version;

import java.util.List;

public class ExamPaperService {

    ExamPaperDao dao = new ExamPaperDao();

    public List<ExamPaper> selectByExamSetter(int examSetterId) {
        return dao.selectAll(examSetterId);
    }

    public int insertExamPaper(ExamPaper examPaper) {
        int rst = dao.insertOne(examPaper);
        return rst;
    }

    public int insertOneVersion(Version version) {
        return -1;
    }
}
