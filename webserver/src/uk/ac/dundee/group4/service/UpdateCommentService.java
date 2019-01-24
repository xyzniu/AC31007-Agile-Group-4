package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UpdateCommentDao;


/**
 * This is a Service dealing with updating comments.
 */
public class UpdateCommentService {

    private UpdateCommentDao updatecommentDao = new UpdateCommentDao();

    /**
     * update comment by comment id and comment
     *
     * @param comment_id
     * @param comment
     */
    public void updateComment(String comment_id, String comment) {
        updatecommentDao.UpdateComment(comment_id, comment);
    }
}
