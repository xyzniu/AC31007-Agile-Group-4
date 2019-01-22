package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.CommentDao;
import uk.ac.dundee.group4.pojo.Comment;
;

import java.util.List;

public class CommentService {

    private CommentDao commentDao = new CommentDao();


    public List<Comment> selectAll(){
        //System.out.println(commentDao.selectAll());
        return commentDao.selectAll();
    }
    public void insertComment(String comment_id, String comment){
        //System.out.println(commentDao.selectAll());
        commentDao.insertComment(comment_id,comment);
    }
}
