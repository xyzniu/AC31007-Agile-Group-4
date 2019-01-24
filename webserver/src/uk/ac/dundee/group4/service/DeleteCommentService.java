package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.DeleteCommentDao;


/**
 * This is a Service dealing with deleting comments.
 */
public class DeleteCommentService {

    private DeleteCommentDao deleteCommentDao = new DeleteCommentDao();

    /**
     * delete comments by comment id
     * @param comment_id
     */
    public void deleteComment(String comment_id){
        System.out.println(comment_id);
        deleteCommentDao.DeleteComment(comment_id);

    }
}
