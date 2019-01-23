package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.ExamPaperDao;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.Version;

import java.util.List;

public class ExamPaperService {

    ExamPaperDao dao = new ExamPaperDao();

    public List<ExamPaper> selectByExamSetter(int examSetterId, String staffName) {
        List<ExamPaper> examPapers = dao.selectByExamSetter(examSetterId);
        for (ExamPaper paper : examPapers) {
            paper.setExamSetter(staffName);
        }
        return examPapers;
    }

    public int insertExamPaper(ExamPaper examPaper) {
        int rst = dao.insertOne(examPaper);
        return rst;
    }

    public Version selectUrlByModuleCodeAndLevel(String moduleCode, int level) {
        return dao.selectByExamPaperId(moduleCode, level);
    }

    public List<ExamPaper> selectAll() {
        return dao.selectAll();
    }

    public List<ExamPaper> selectByStaffID(int id, int type) {
        return dao.selectByStaffID(id, type);

    }
}
