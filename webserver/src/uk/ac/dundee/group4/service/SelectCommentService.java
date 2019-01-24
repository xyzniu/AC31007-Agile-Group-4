package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.SelectCommentDao;
import uk.ac.dundee.group4.pojo.SelectComment;

;import java.util.List;

/**
 * This is a Service dealing with selecting comments.
 */
public class SelectCommentService {

    public SelectCommentService(){}

    private SelectCommentDao selectCommentDao = new SelectCommentDao();

    /**
     * querying comments by exam paper id
     * @param exam_paper_id
     * @return
     */
    public List<SelectComment> selectComment(String exam_paper_id){
        return selectCommentDao.SelectComment(exam_paper_id);
    }
}
