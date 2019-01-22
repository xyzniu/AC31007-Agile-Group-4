package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.InsertCommentDao;
import uk.ac.dundee.group4.pojo.InsertComment;

import java.util.List;

;

public class InsertCommentService {

    private InsertCommentDao insertCommentDao = new InsertCommentDao();

    public void insertComment(String comment_id, String comment){
        System.out.println(comment_id);
        System.out.println(comment);
        insertCommentDao.InsertComment(comment_id,comment);
    }
}
