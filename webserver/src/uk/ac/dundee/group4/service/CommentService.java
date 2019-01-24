package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.CommentDao;
import uk.ac.dundee.group4.pojo.Comment;
;

import java.util.List;

/**
 * This is a Service dealing with comments.
 */
public class CommentService {
    private CommentDao commentDao = new CommentDao();

    /**
     * querying all comments
     * @return
     */
    public List<Comment> selectAll(){
        return commentDao.selectAll();
    }

}
