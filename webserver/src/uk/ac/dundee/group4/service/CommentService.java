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

}
