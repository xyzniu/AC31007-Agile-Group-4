package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.InsertCommentDao;


public class InsertCommentService {

    private InsertCommentDao insertCommentDao = new InsertCommentDao();


    public void insertComment(String comment, String exam_paper_id, String user_id, String staff_type) {
        insertCommentDao.InsertComment(comment, exam_paper_id, user_id, staff_type);
    }
}
