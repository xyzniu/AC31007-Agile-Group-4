package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.UpdateCommentDao;

;

public class UpdateCommentService {

    private UpdateCommentDao updatecommentDao = new UpdateCommentDao();

    public void updateComment(String comment_id, String comment){
        System.out.println(comment_id);
        System.out.println(comment);
        updatecommentDao.UpdateComment(comment_id,comment);
    }
}
