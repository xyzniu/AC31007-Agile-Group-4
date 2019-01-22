package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.DeleteCommentDao;

;

public class DeleteCommentService {

    private DeleteCommentDao deleteCommentDao = new DeleteCommentDao();

    public void deleteComment(String comment_id){
        System.out.println(comment_id);
        deleteCommentDao.DeleteComment(comment_id);

    }
}
