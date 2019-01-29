package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.InsertCommentDao;

/**
 * This is a Service dealing with inserting comments.
 */
public class InsertCommentService {

    private InsertCommentDao insertCommentDao = new InsertCommentDao();


    /**
     * insert comments
     *
     * @param comment
     * @param exam_paper_id
     * @param user_id
     * @param staff_type
     */
    public void insertComment(String comment, String exam_paper_id, String user_id, String staff_type, String version_id) {
        insertCommentDao.InsertComment(comment, exam_paper_id, user_id, staff_type, version_id);
    }
}
