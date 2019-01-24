package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.SelectCommentDao;
import uk.ac.dundee.group4.pojo.SelectComment;

;import java.util.List;

public class SelectCommentService {

    private SelectCommentDao selectCommentDao = new SelectCommentDao();

    public List<SelectComment> selectComment(String exam_paper_id){

        return selectCommentDao.SelectComment(exam_paper_id);
    }
}
